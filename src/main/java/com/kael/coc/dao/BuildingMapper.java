package com.kael.coc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
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

    @Select("select * from building where userId=#{userId} and xmlId=#{xmlId}")
    List<Building> findBuildingsByUserIdAndXmlId(@Param("userId") Integer userId, @Param("xmlId") Integer xmlId );

    @Select("select * from building where userId=#{userId} and buildId=#{buildId}")
    Building findBuildingByUserId(@Param("userId") Integer userId, @Param("buildId") Integer buildId );

    @Select("select * from building where userId=#{userId} and posX=#{posX} and posY=#{posY}")
    Building findBuildingByUserIdPos(@Param("userId") Integer userId, @Param("posX") Integer posX, @Param("posY") Integer posY );
}