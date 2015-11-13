package com.kael.coc.data;

import java.util.HashMap;

public class GlobalCfg {

	private HashMap<String, Integer> platformId2UserId  = new HashMap<String, Integer>();
	private int maxUserId;
	private int minUserId;


	public int getMaxUserId() {
		return maxUserId;
	}
	public void setMaxUserId(int maxUserId) {
		this.maxUserId = maxUserId;
	}

	public int getMinUserId() {
		return minUserId;
	}

	public void setMinUserId(int minUserId) {
		this.minUserId = minUserId;
	}
	
	public boolean findIsStarted() {
		return maxUserId == minUserId;
	}
	public HashMap<String, Integer> getPlatformId2UserId() {
		return platformId2UserId;
	}
	public void setPlatformId2UserId(HashMap<String, Integer> platformId2UserId) {
		this.platformId2UserId = platformId2UserId;
	}
}
