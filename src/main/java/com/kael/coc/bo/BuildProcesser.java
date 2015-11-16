package com.kael.coc.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.kael.coc.data.BuildElemet;
import com.kael.coc.data.BuildingData;
import com.kael.coc.support.Constant;
import com.kael.coc.support.RandomUtil;
/**
 * 
 * @author kael
 * 
 */
public class BuildProcesser {
	private final List<Building> buildings;
	private final List<Barrier> barriers;
	private final Set<String> maps = new HashSet<String>();
	private Integer userId;
	private BuildingData buildingData;

	public BuildProcesser(BuildingData buildingData, List<Building> buildings, List<Barrier> barriers, Integer userId) {
		super();
		this.userId = userId;
		this.buildingData = buildingData;
		this.buildings = (buildings == null ? new ArrayList<Building>() : buildings);
		
		this.barriers = (barriers == null ? new ArrayList<Barrier>() : barriers);
		
		if(!this.buildings.isEmpty()){
			for (Building building : this.buildings) {
				BuildElemet elemet = buildingData.findBuildElement(building.getXmlId());
				for(String e : findBuildingPos(building.getPosX(), building.getPosY(), elemet.getSize())){
					maps.add(e);
				}
			}
		}
		
		if(!this.barriers.isEmpty()){
			for (Barrier building : this.barriers) {
				BuildElemet elemet = buildingData.findBuildElement(building.getXmlId());
				for(String e : findBuildingPos(building.getPosX(), building.getPosY(), elemet.getSize())){
					maps.add(e);
				}
			}
		}
	}
	
	private static String[] findBuildingPos(int posX, int posY, int size){
		if(posX >= 0 && posY >= 0 && posX +size < 400 && posY +size < 400){
			String[] str = new String[size * size];
			int k = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					str[k++] = (posX+i)+"_"+(posY+j);
				}
			}
			return str;
		}
		System.out.printf("posX(%d),posY(%d),size(%d)\n", posX,posY,size);
		return null;
	}

	public List<Barrier> processNewBarriers(int length) {
		if(length <= 0 || barriers.size() >= Constant.maxBarrierNum){
			return new ArrayList<Barrier>() ;
		}
		List<Barrier> tmpBarriers = new ArrayList<Barrier>(length);
		for (int i = 0; i < length; i++) {
			int x = -1;
			int y = -1;
			int xmlId = 0;
			do{
				xmlId = buildingData.nextBarrierId(true);
				int size = buildingData.findBuildElement(xmlId).getSize();
				x =RandomUtil.nextInt(400 - size);
				y = RandomUtil.nextInt(400 - size);
				String[] str = findBuildingPos(x, y, size);
				boolean match = true;
				for (String e : str) {
					if(maps.contains(e)){
						match = false;
						break;
					}
				}
				
				if(match){
					Barrier barrier = new Barrier();
					barrier.setPosX(x);
					barrier.setPosY(y);
					barrier.setXmlId(xmlId);
					barrier.setUserId(userId);
					barriers.add(barrier);
					tmpBarriers.add(barrier);
					for (String e : str) {
						maps.add(e);
					}
					break;
				}
				
			}while(true);
			if(barriers.size() >= Constant.maxBarrierNum){
				break;
			}
		}
		return tmpBarriers;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public List<Barrier> getBarriers() {
		return barriers;
	}
	
	

}
