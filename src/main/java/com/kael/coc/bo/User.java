package com.kael.coc.bo;

import java.util.Date;

public class User {
    private Integer id;

    private String platformId;

    private Integer rank;

    private Integer fame;

    private Date lastLoginTime;

    private Integer dimaond;

    private Integer buildingId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId == null ? null : platformId.trim();
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getFame() {
        return fame;
    }

    public void setFame(Integer fame) {
        this.fame = fame;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getDimaond() {
        return dimaond;
    }

    public void setDimaond(Integer dimaond) {
        this.dimaond = dimaond;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public Integer incrAndGetBuildingId() {
    	return ++buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }
}