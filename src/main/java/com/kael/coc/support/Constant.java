package com.kael.coc.support;

import java.util.concurrent.TimeUnit;

public class Constant {

	public static final int[] clearBarriersGetDimamod = {6,0,4,5,1,3,2,0,0,5,1,0,3,4,0,5,0,1,0};
	public static final int maxBarrierNum = 40;
	public static final int TownHallXmlId = 1000;
	public static final int GoldStorageXmlId = 1003;
	public static final int ElixirCollectorXmlId = 1004;
	public static final long OffTimeProduceBarrier = TimeUnit.HOURS.toMillis(8);
	
	public static int getDimaond(int clearBarriersNum){
		return clearBarriersGetDimamod[clearBarriersNum%clearBarriersGetDimamod.length];
	}
}
