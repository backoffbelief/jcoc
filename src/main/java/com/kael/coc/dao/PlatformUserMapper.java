package com.kael.coc.dao;

import com.kael.coc.bo.PlatformUser;

public interface PlatformUserMapper {
    int deleteByPrimaryKey(String platformId);

    int insert(PlatformUser record);

    int insertSelective(PlatformUser record);

    PlatformUser selectByPrimaryKey(String platformId);

    int updateByPrimaryKeySelective(PlatformUser record);

    int updateByPrimaryKey(PlatformUser record);
}