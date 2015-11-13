package com.kael.coc.bo;

import java.util.Date;

public class Building {
    private Integer id;

    private Integer userId;

    private Integer xmlId;

    private Integer posX;

    private Integer posY;

    private Integer level;

    private Integer goldNum;

    private Integer elixirNum;

    private Integer currHp;

    private Date endBuildingTime;

    private Date lastCollectTime;

    private Integer buildId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getXmlId() {
        return xmlId;
    }

    public void setXmlId(Integer xmlId) {
        this.xmlId = xmlId;
    }

    public Integer getPosX() {
        return posX;
    }

    public void setPosX(Integer posX) {
        this.posX = posX;
    }

    public Integer getPosY() {
        return posY;
    }

    public void setPosY(Integer posY) {
        this.posY = posY;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getGoldNum() {
        return goldNum;
    }

    public void setGoldNum(Integer goldNum) {
        this.goldNum = goldNum;
    }

    public Integer getElixirNum() {
        return elixirNum;
    }

    public void setElixirNum(Integer elixirNum) {
        this.elixirNum = elixirNum;
    }

    public Integer getCurrHp() {
        return currHp;
    }

    public void setCurrHp(Integer currHp) {
        this.currHp = currHp;
    }

    public Date getEndBuildingTime() {
        return endBuildingTime;
    }

    public void setEndBuildingTime(Date endBuildingTime) {
        this.endBuildingTime = endBuildingTime;
    }

    public Date getLastCollectTime() {
        return lastCollectTime;
    }

    public void setLastCollectTime(Date lastCollectTime) {
        this.lastCollectTime = lastCollectTime;
    }

    public Integer getBuildId() {
        return buildId;
    }

    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }
}