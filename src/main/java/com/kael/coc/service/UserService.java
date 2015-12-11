package com.kael.coc.service;

import java.util.Map;

public interface UserService {

	Map<String, Object> getUserInfo(String platformId);

	Map<String, Object> deleteBarrier(Integer userId, String pos);

	Map<String, Object> upgradeBuilding(Integer userId, Integer buildId);

	Map<String, Object> createNewBuild(Integer userId, Integer buildId, String buildPos);
}
