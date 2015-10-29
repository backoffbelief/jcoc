package com.kael.coc.bo;
/**
 * 圣水收集器
 * @author Administrator
 *
 */
public class ElixirCollector extends ResourcePool {

	protected long lastCollectTime;

	public long getLastCollectTime() {
		return lastCollectTime;
	}

	public void setLastCollectTime(long lastCollectTime) {
		this.lastCollectTime = lastCollectTime;
	}
	
}
