package com.kael.coc.bo;
/**
 * 圣水收集器
 * @author kael
 *
 */
public class Collector extends ResourcePool {

	protected long lastCollectTime;

	public long getLastCollectTime() {
		return lastCollectTime;
	}

	public void setLastCollectTime(long lastCollectTime) {
		this.lastCollectTime = lastCollectTime;
	}

	@Override
	public boolean reflush() {
		if(endBuildingTime > 0){
			if(endBuildingTime <= System.currentTimeMillis()){
				lastCollectTime = endBuildingTime;
				endBuildingTime = 0;
				level++;
				return true;
			}
		}
		return false;
	}
	
}
