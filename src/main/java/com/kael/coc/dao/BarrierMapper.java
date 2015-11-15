package com.kael.coc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kael.coc.bo.Barrier;

public interface BarrierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Barrier record);

    int insertSelective(Barrier record);

    Barrier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Barrier record);

    int updateByPrimaryKey(Barrier record);
    
    @Select("select * from barrier where userId= #{userId}")
    List<Barrier> findAllBarriersByUser(Integer userId);
    
    @Select("select * from barrier where userId= #{userId} and posX=#{posX} and posY = #{posY}")
    Barrier findBarrier(@Param("userId")Integer userId, @Param("posX") Integer posX, @Param("posY")Integer posY);
}