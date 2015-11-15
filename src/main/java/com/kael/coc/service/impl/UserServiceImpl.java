package com.kael.coc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.kael.coc.bo.Barrier;
import com.kael.coc.bo.BuildProcesser;
import com.kael.coc.bo.Building;
import com.kael.coc.bo.PlatformUser;
import com.kael.coc.bo.User;
import com.kael.coc.dao.BarrierMapper;
import com.kael.coc.dao.BuildingMapper;
import com.kael.coc.dao.PlatformUserMapper;
import com.kael.coc.dao.UserMapper;
import com.kael.coc.service.UserService;
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper ;
	@Autowired
	private PlatformUserMapper platformUserMapper ;
	@Autowired
	private BuildingMapper buildingMapper;
	@Autowired
	private BarrierMapper barrierMapper;

	@Override
	public Map<String, Object> getUserInfo(String platformId) {
		PlatformUser platformUser = platformUserMapper.selectByPrimaryKey(platformId);
		User user = null;
		List<Building> buildings = new ArrayList<Building>();
		List<Barrier> barriers = null;
		Map<String, Object> result = new HashMap<String, Object>();
		boolean isNewUser = false;
		if(platformUser == null){
			user = new User();
			user.setBuildingId(1);
			user.setDimaond(250);
			user.setFame(100);
			user.setLastLoginTime(new Date(System.currentTimeMillis()));
			user.setPlatformId(platformId);
			user.setRank(1);
			userMapper.insert(user);
			
			platformUser = new PlatformUser();
			platformUser.setPlatformId(platformId);
			platformUser.setUserId(user.getId());
			
			platformUserMapper.insert(platformUser);
			
			Building building = new Building();
			building.setBuildId(user.incrAndGetBuildingId());
			building.setCurrHp(100);
			building.setElixirNum(100);
			building.setGoldNum(100);
			building.setLevel(1);
			building.setPosX(0);
			building.setPosY(0);
			building.setUserId(user.getId());
			building.setEndBuildingTime(new Date(System.currentTimeMillis()));
			building.setXmlId(1);
			
			buildingMapper.insertSelective(building);
			buildings.add(building);
			
			BuildProcesser buildProcesser = new BuildProcesser(buildings, barriers, user.getId());
			buildProcesser.processNewBarriers(5);
			
			barriers = buildProcesser.getBarriers();
			for (Barrier barrier : barriers) {
				barrierMapper.insertSelective(barrier);
			}
			
			isNewUser = true;
		}else{
			user = userMapper.selectByPrimaryKey(platformUser.getUserId());
			buildings.addAll(buildingMapper.findBuildingsByUserId(user.getId()));
			barriers = barrierMapper.findAllBarriersByUser(user.getId());
			if(barriers.isEmpty()){
				BuildProcesser buildProcesser = new BuildProcesser(buildings, barriers, user.getId());
				buildProcesser.processNewBarriers(5);
				barriers = buildProcesser.getBarriers();
				for (Barrier barrier : barriers) {
					barrierMapper.insertSelective(barrier);
				}
			}
		}
		result.put("isNewUser", isNewUser);
		result.put("user", user);
		result.put("buildings", buildings);
		result.put("barriers", barriers);
		return result;
	}
}
