package com.kael.coc.bo;

import com.alibaba.fastjson.annotation.JSONField;

public class Barrier {
	
	@JSONField(serialize=false)
    private Integer id;

    private Integer userId;

    private Integer xmlId;

    private Integer posX;

    private Integer posY;

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
}