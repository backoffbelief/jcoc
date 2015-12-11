package com.kael.coc.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.kael.coc.support.BusinessException;
import com.kael.coc.support.ErrorCode;
import com.kael.coc.support.IntHashMap;
import com.kael.coc.support.JsonUtils;
import com.kael.coc.support.RandomUtil;

@Component
public class BuildingData {
   
	private IntHashMap<BuildElemet> bulidElements = new IntHashMap<BuildElemet>();
	
	private int[] weigts_plants;
	private int[] plants ;

	private int[] stones ;
	
	@PostConstruct
	public void init(){
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		List<Integer> plantList = new ArrayList<Integer>();
		List<Integer> stonesList = new ArrayList<Integer>();
		List<Integer> weigts_plantList = new ArrayList<Integer>();
		//List<Integer> weigts_stonesList = new ArrayList<Integer>();
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(classLoader.getResourceAsStream("coc_bulid.json")))){
			StringBuilder builder = new StringBuilder();
			String line ;
			while((line = reader.readLine()) != null){
				builder.append(line);
			}
			List<BuildElemet> buildList = JsonUtils.fromJSONToList(builder.toString(), BuildElemet.class);
			for (BuildElemet buildElemet : buildList) {
				bulidElements.put(buildElemet.getXmlId(), buildElemet);
				if(buildElemet.getXmlId() >= 2000 && buildElemet.getXmlId() < 3000 ){
					plantList.add(buildElemet.getXmlId());
					weigts_plantList.add(buildElemet.getWeight());
				}else if(buildElemet.getXmlId() >= 3000 && buildElemet.getXmlId() < 4000 ){
					stonesList.add(buildElemet.getXmlId());
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		plants = parse(plantList);
		stones = parse(stonesList);
		weigts_plants = parse(weigts_plantList);
		if(plants.length != weigts_plants.length){
			throw new IllegalArgumentException(String.format("plantsSize(%d)!=weigts_plantsSize(%d)", plants.length, weigts_plants.length));
		}
	}
	
	private static int[] parse(List<Integer> list){
		if(list == null || list.isEmpty()){
			return new int[0];
		}
		int[] ret = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}
	public BuildElemet findBuildElement(int xmlId){
		BuildElemet buildElemet = bulidElements.get(xmlId);
		if(buildElemet == null){
			throw new BusinessException(ErrorCode.NotExistBuildingElement,String.format("not exist building xmlId(%d)",xmlId));
		}
		return buildElemet;
	}
	
	public int nextBarrierId(boolean plant){
		if(plant){
			return plants[RandomUtil.rndInWeights(weigts_plants)];
		}
		return stones[RandomUtil.nextInt(stones.length)];
	}
}
