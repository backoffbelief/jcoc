package com.kael.coc.bo;
/**
 * 父类
 * @author kael
 *
 */
public class Building {
	protected int level;
	protected int id;
	protected int xmlId;
	protected int posX;
	protected int posY;
	protected long endBuildingTime;// 建造结束的时间
	protected int currHp;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getXmlId() {
		return xmlId;
	}

	public void setXmlId(int xmlId) {
		this.xmlId = xmlId;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public long getEndBuildingTime() {
		return endBuildingTime;
	}

	public void setEndBuildingTime(long endBuildingTime) {
		this.endBuildingTime = endBuildingTime;
	}

	public int getCurrHp() {
		return currHp;
	}

	public void setCurrHp(int currHp) {
		this.currHp = currHp;
	}
	
	public boolean reflush(){
		if(endBuildingTime > 0){
			if(endBuildingTime <= System.currentTimeMillis()){
				endBuildingTime = 0;
				level++;
				return true;
			}
		}
		return false;
	}

}
