package com.kael.coc.data;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.kael.coc.bo.User;
import com.kael.coc.bo.WrapUserData;

/**
 * 每个人的数据分别存在不同的玩家文件里
 * 全局的数据存在global.json
 * @author 
 *
 */
public class UserDB {
	
	private static AtomicInteger id ;
	private static GlobalCfg globalCfg;
	private static final Map<Integer, WrapUserData> datas = new ConcurrentHashMap<>(); 
	
	static{
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		try {
			globalCfg = readObjFromJsonFile(GlobalCfg.class, cl, "global.json");
			if(globalCfg == null)
			{
				globalCfg = new GlobalCfg();
				globalCfg.setMinUserId(0);
				globalCfg.setMaxUserId(0);
				globalCfg.setPlatformId2UserId(HashBiMap.create(new HashMap<String,Integer>()));
				writeObjToJsonFile(globalCfg,"/src/main/resources/global.json");
			}
			id = new AtomicInteger(globalCfg.getMaxUserId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (!globalCfg.isStarted())
		{
			boolean isStore = false;
			for(int userId = globalCfg.getMinUserId() ; userId < globalCfg.getMaxUserId(); userId ++){
				if(globalCfg.getPlatformId2UserId().containsValue(userId)){
					
					try{
						datas.put(userId, readObjFromJsonFile(WrapUserData.class,cl, "user_"+userId+".json"));
					}catch (Exception e) {
						e.printStackTrace();
						BiMap<Integer, String> inverse = globalCfg.getPlatformId2UserId().inverse();
						inverse.remove(userId);
						globalCfg.setPlatformId2UserId(HashBiMap.create(inverse.inverse()));
						isStore = true;
					}
				}
			}
			
			if(isStore){
				writeObjToJsonFile(globalCfg,"/src/main/resources/global.json");
			}
		}
	}
	
	private static <T> T readObjFromJsonFile(Class<T> cls, ClassLoader cl, String fileName){
		if(cl == null)
		{
			cl = Thread.currentThread().getContextClassLoader();
		}
		
		try(JSONReader reader = new JSONReader(new BufferedReader(new InputStreamReader(cl.getResourceAsStream(fileName))))){
			return JSON.parseObject(reader.readString(), cls);
		}catch (Exception e) {
			throw new RuntimeException(e);
		} 
		
	}

	private static <T> T readObjFromJsonFile(Class<T> cls, String fileName){
		return readObjFromJsonFile(cls, null, fileName);
	}

	private static void writeObjToJsonFile(Object obj,String fileName) {
		try(JSONWriter writer = new JSONWriter(new FileWriter(System.getProperty("user.dir")+fileName)))
		{
			writer.config(SerializerFeature.PrettyFormat, true);
			writer.writeObject(obj);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static boolean contains(String platformId){
		return globalCfg.getPlatformId2UserId().containsKey(platformId);
	}
	
	public static int getUniqeId()
	{
		return id.incrementAndGet();
	}
	
	
	public static User getUser(int userId){
		WrapUserData wrapUserData = null;
		if((wrapUserData = datas.get(userId)) == null){
			
		}
		return null;
	}
	
	
	private static WrapUserData getAndSet(int userId)
	{
		return null;
	}

	public static void addPlat2UserId(String platformId, int userId) {
		globalCfg.getPlatformId2UserId().put(platformId, userId);
	}

}
