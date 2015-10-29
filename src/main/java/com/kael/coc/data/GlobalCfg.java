package com.kael.coc.data;

import com.google.common.collect.HashBiMap;

public class GlobalCfg {

	private HashBiMap<String, Integer> platformId2UserId;
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

	public boolean isStarted() {
		return maxUserId == minUserId;
	}

	public HashBiMap<String, Integer> getPlatformId2UserId() {
		return platformId2UserId;
	}

	public void setPlatformId2UserId(HashBiMap<String, Integer> platformId2UserId) {
		this.platformId2UserId = platformId2UserId;
	}

	
}
