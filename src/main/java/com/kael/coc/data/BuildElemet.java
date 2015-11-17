package com.kael.coc.data;

import com.kael.coc.bo.Building;
import com.kael.coc.bo.Cost;
import com.kael.coc.bo.Produce;
import com.kael.coc.bo.User;
import com.kael.coc.support.BusinessException;
import com.kael.coc.support.ErrorCode;
import com.kael.coc.support.MathUtil;

public class BuildElemet implements Comparable<BuildElemet>{

	private int xmlId;
	private int size;
	private int[] hps;
	private long[] upgradeTime;
	private int maxLevel;
	private String name;

	private int[] upgradeNeedGold;
	private int[] goldCapacity;
	private int[] goldMineSpeedPerHour;

	private int[] upgradeNeedElixir;
	private int[] elixirCapacity;
	private int[] elixirCollectorSpeedPerHour;

	private int[] solidersCapacity;
	
	private int[] fames;
	private int[] needUserRank;
	private int[] needTownLevel;

	private int[] goldMineNums;
	private int[] elixirCollectorNums;
	private int[] goldStorageNums ;
	private int[] elixirStorageNums;
	private int[] armyCampNums;
	private int[] barracksNums;
	
	//障碍物
	private int clearCostTime;
	private int fame;
	private int costElixir;
	private int costGold;
	private int weight;
	
	public int getXmlId() {
		return xmlId;
	}

	public void setXmlId(int xmlId) {
		this.xmlId = xmlId;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[] getHps() {
		return hps;
	}

	public void setHps(int[] hps) {
		this.hps = hps;
	}

	public long[] getUpgradeTime() {
		return upgradeTime;
	}

	public void setUpgradeTime(long[] upgradeTime) {
		this.upgradeTime = upgradeTime;
	}

	public int getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getUpgradeNeedGold() {
		return upgradeNeedGold;
	}

	public void setUpgradeNeedGold(int[] upgradeNeedGold) {
		this.upgradeNeedGold = upgradeNeedGold;
	}

	public int[] getGoldMineNums() {
		return goldMineNums;
	}

	public void setGoldMineNums(int[] goldMineNums) {
		this.goldMineNums = goldMineNums;
	}

	public int[] getGoldCapacity() {
		return goldCapacity;
	}

	public void setGoldCapacity(int[] goldCapacity) {
		this.goldCapacity = goldCapacity;
	}

	public int[] getGoldMineSpeedPerHour() {
		return goldMineSpeedPerHour;
	}

	public void setGoldMineSpeedPerHour(int[] goldMineSpeedPerHour) {
		this.goldMineSpeedPerHour = goldMineSpeedPerHour;
	}

	public int[] getUpgradeNeedElixir() {
		return upgradeNeedElixir;
	}

	public void setUpgradeNeedElixir(int[] upgradeNeedElixir) {
		this.upgradeNeedElixir = upgradeNeedElixir;
	}

	public int[] getNeedTownLevel() {
		return needTownLevel;
	}

	public void setNeedTownLevel(int[] needTownLevel) {
		this.needTownLevel = needTownLevel;
	}

	public int[] getElixirCollectorNums() {
		return elixirCollectorNums;
	}

	public void setElixirCollectorNums(int[] elixirCollectorNums) {
		this.elixirCollectorNums = elixirCollectorNums;
	}

	public int[] getElixirCapacity() {
		return elixirCapacity;
	}

	public void setElixirCapacity(int[] elixirCapacity) {
		this.elixirCapacity = elixirCapacity;
	}

	public int[] getElixirCollectorSpeedPerHour() {
		return elixirCollectorSpeedPerHour;
	}

	public void setElixirCollectorSpeedPerHour(int[] elixirCollectorSpeedPerHour) {
		this.elixirCollectorSpeedPerHour = elixirCollectorSpeedPerHour;
	}

	public int[] getNeedUserRank() {
		return needUserRank;
	}

	public void setNeedUserRank(int[] needUserRank) {
		this.needUserRank = needUserRank;
	}

	public int[] getFames() {
		return fames;
	}

	public void setFames(int[] fames) {
		this.fames = fames;
	}

	public int[] getGoldStorageNums() {
		return goldStorageNums;
	}

	public void setGoldStorageNums(int[] goldStorageNums) {
		this.goldStorageNums = goldStorageNums;
	}

	public int[] getElixirStorageNums() {
		return elixirStorageNums;
	}

	public void setElixirStorageNums(int[] elixirStorageNums) {
		this.elixirStorageNums = elixirStorageNums;
	}

	public int[] getArmyCampNums() {
		return armyCampNums;
	}

	public void setArmyCampNums(int[] armyCampNums) {
		this.armyCampNums = armyCampNums;
	}

	public int[] getBarracksNums() {
		return barracksNums;
	}

	public void setBarracksNums(int[] barracksNums) {
		this.barracksNums = barracksNums;
	}

	public int[] getSolidersCapacity() {
		return solidersCapacity;
	}

	public void setSolidersCapacity(int[] solidersCapacity) {
		this.solidersCapacity = solidersCapacity;
	}

	@Override
	public int compareTo(BuildElemet o) {
			return this.getXmlId()   - ((BuildElemet)o).getXmlId();
	}

	public int getClearCostTime() {
		return clearCostTime;
	}

	public void setClearCostTime(int clearCostTime) {
		this.clearCostTime = clearCostTime;
	}

	public int getFame() {
		return fame;
	}

	public void setFame(int fame) {
		this.fame = fame;
	}

	public int getCostElixir() {
		return costElixir;
	}

	public void setCostElixir(int costElixir) {
		this.costElixir = costElixir;
	}

	public int getCostGold() {
		return costGold;
	}

	public void setCostGold(int costGold) {
		this.costGold = costGold;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
	public Cost findCost(int level, User user, Building town){
		if(needUserRank != null && user.getRank()<needUserRank[level  -1 ]){
			throw new BusinessException(ErrorCode.ThisBuildingNeedMoreHigherRank, "");
		}
		if(needTownLevel != null &&  town.getLevel() < needTownLevel[level - 1]){
			throw new BusinessException(ErrorCode.ThisBuildingNeedMoreHigherRank, "");
		}
		
		Cost c = new Cost();
		if(upgradeNeedGold != null){
			c.setGoldNum( upgradeNeedGold[level -1]);
		}
		if(upgradeNeedElixir != null){
			c.setElixirNum(upgradeNeedElixir[level -1]);
		}
		if(upgradeTime != null){
			c.setCostSeconds(upgradeTime[level-1]);
		}
		return c;
	}
 
	public Produce findProduce(Integer level, long interval) {
		Produce p = new Produce();
		if(goldMineSpeedPerHour != null){
			p.setGoldNum(Math.min(MathUtil.cal(goldMineSpeedPerHour[level - 1], interval), goldCapacity[level - 1 ]));
		}else if(elixirCollectorSpeedPerHour!= null){
			p.setElixirNum(Math.min(MathUtil.cal(elixirCollectorSpeedPerHour[level - 1], interval), elixirCapacity[level - 1 ]));
		}
		return p;
	}
}
