package com.kael.coc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kael.coc.bo.Building;

public interface BuildingMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Building record);

    int insertSelective(Building record);

    Building selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Building record);

    int updateByPrimaryKey(Building record);
    
    @Select("select * from building where userId=#{userId}")
    List<Building> findBuildingsByUserId(Integer userId);
}