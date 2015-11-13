package com.kael.coc.bo;

import java.util.concurrent.atomic.AtomicInteger;

public class User {

	private String platformId;
	private int userId;
	private int rank;
	private int fame;
	private long lastLoginTime;
	private int dimaond;
	private AtomicInteger buildingId;

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getFame() {
		return fame;
	}

	public void setFame(int fame) {
		this.fame = fame;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public int getDimaond() {
		return dimaond;
	}

	public void setDimaond(int dimaond) {
		this.dimaond = dimaond;
	}

	public int getBuildingId() {
		return buildingId.get();
	}

	public void setBuildingId(int buildingId) {
		this.buildingId = new AtomicInteger(buildingId);
	}
	
	public int nextBuildingId(){
		return buildingId.incrementAndGet();
	}

}
