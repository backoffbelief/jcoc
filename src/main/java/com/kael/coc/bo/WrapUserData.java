package com.kael.coc.bo;

import java.util.List;

public class WrapUserData {

	private User user;
	private List<Building> buildings;
	private TownHall townHall ;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}
	
	public boolean reflush(){
		boolean change = false;
		for(Building building : buildings){
			change |= building.reflush();
		}
		return change;
	}

}
