package com.kael.coc.data;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kael.coc.bo.WrapUserData;

/**
 * 每个人的数据分别存在不同的玩家文件里
 * 全局的数据存在global.json
 * @author 
 *
 */
public class UserDB {
	private static final String SYSTEM_DIR = System.getProperty("user.dir");
	private static final String PROJECT_DIR = "/src/main/resources";
	private static final String GLOBAL_FILE = "global.json";
	private static final String GLOBAL_DST_FILE = PROJECT_DIR+"/"+GLOBAL_FILE;
	private static AtomicInteger id ;
	private static GlobalCfg globalCfg;
	private static final Map<Integer, WrapUserData> datas = new ConcurrentHashMap<>(); 
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
		try(JSONWriter writer = new JSONWriter(new FileWriter(SYSTEM_DIR+fileName)))
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
	
	
	public static WrapUserData getUser(int userId){
		WrapUserData wrapUserData = null;
		if((wrapUserData = datas.get(userId)) == null){
			wrapUserData = readObjFromJsonFile(WrapUserData.class, "user_"+userId+".json");
			if(wrapUserData != null){
				datas.put(userId, wrapUserData);
			}else{
				throw new RuntimeException("userId:"+userId+", not exist!!!!");
			}
		}
		return wrapUserData;
	}

	public static WrapUserData getUser(String platformId){
		
		return getUser(globalCfg.getPlatformId2UserId().get(platformId));
	}
	
	
	public static void saveDb(int userId, WrapUserData userData)
	{
		if(userData == null || userData.getUser() == null || userData.getBuildings() == null){
			
			throw new RuntimeException("sdadsdad----------");
		}
		
		writeObjToJsonFile(userData, PROJECT_DIR+"/"+"user_"+userId+".json");
	}

	public static void addPlat2UserId(String platformId, int userId) {
		globalCfg.getPlatformId2UserId().put(platformId, userId);
		writeObjToJsonFile(globalCfg,GLOBAL_DST_FILE);
	}

	public static void loadGame() {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		boolean isStore = false;
		try {
			globalCfg = readObjFromJsonFile(GlobalCfg.class, cl, GLOBAL_FILE);
			if(globalCfg == null){
				globalCfg = new GlobalCfg();
				globalCfg.setMinUserId(0);
				globalCfg.setMaxUserId(0);
				isStore = true;
			}
			id = new AtomicInteger(globalCfg.getMaxUserId());
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		if (!globalCfg.findIsStarted()){
			HashMap<String, Integer> platformId2UserId = globalCfg.getPlatformId2UserId();
			for(Iterator<Entry<String, Integer>> iterator  = platformId2UserId.entrySet().iterator(); iterator.hasNext();){
				Entry<String, Integer> entry = iterator.next();
				if(entry == null){
					continue;
				}
				int userId = entry.getValue().intValue();
				try{
					WrapUserData wrapUserData = readObjFromJsonFile(WrapUserData.class,cl, "user_"+userId+".json");
					if(wrapUserData == null){
						continue;
					}
					if(wrapUserData.reflush()){
						saveDb(userId, wrapUserData);
					}
					datas.put(userId, wrapUserData);
				}catch (Exception e) {
					e.printStackTrace();
					iterator.remove();
					isStore = true;
				}
			}
			
			if(isStore){
				writeObjToJsonFile(globalCfg,GLOBAL_DST_FILE);
			}
		}
	}

}
