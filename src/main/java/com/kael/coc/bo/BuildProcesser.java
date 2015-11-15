package com.kael.coc.bo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

	public BuildProcesser(List<Building> buildings, List<Barrier> barriers, Integer userId) {
		super();
		this.userId = userId;
		this.buildings = (buildings == null ? new ArrayList<Building>() : buildings);
		
		this.barriers = (barriers == null ? new ArrayList<Barrier>() : barriers);
		
		if(!this.buildings.isEmpty()){
			for (Building building : this.buildings) {
				for(String e : findBuildingPos(building.getPosX(), building.getPosY(), 3)){
					maps.add(e);
				}
			}
		}
		
		if(!this.barriers.isEmpty()){
			for (Barrier building : this.barriers) {
				for(String e : findBuildingPos(building.getPosX(), building.getPosY(), 3)){
					maps.add(e);
				}
			}
		}
	}
	
	private String[] findBuildingPos(int posX, int posY, int size){
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

	public void processNewBarriers(int length) {
		if(length <= 0){
			return ;
		}
		Random r = new Random();
		for (int i = 0; i < length; i++) {
			int x = -1;
			int y = -1;
			do
			{
				x = r.nextInt(400 - 3);
				y = r.nextInt(400 - 3);
				String[] str = findBuildingPos(x, y, 3);
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
					barrier.setXmlId(100);
					barrier.setUserId(userId);
					barriers.add(barrier);
					
					for (String e : str) {
						maps.add(e);
					}
					break;
				}
				
			}while(true);
			
		}
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public List<Barrier> getBarriers() {
		return barriers;
	}
	
	

}
