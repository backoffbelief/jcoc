package com.kael.coc.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
import com.kael.coc.data.BuildElemet;
import com.kael.coc.data.BuildingData;
import com.kael.coc.service.UserService;
import com.kael.coc.support.BusinessException;
import com.kael.coc.support.Constant;
import com.kael.coc.support.ErrorCode;
import com.kael.coc.support.TimeUtil;
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper ;
	@Autowired
	private PlatformUserMapper platformUserMapper ;
	@Autowired
	private BuildingMapper buildingMapper;
	@Autowired
	private BarrierMapper barrierMapper;
	@Autowired
	private BuildingData buildingData;

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
			user.setLastLoginTime(new Date(TimeUtil.currentTimeMillis()));
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
			building.setEndBuildingTime(new Date(TimeUtil.currentTimeMillis()));
			building.setXmlId(1);
			
			buildingMapper.insertSelective(building);
			buildings.add(building);
			
			BuildProcesser buildProcesser = new BuildProcesser(buildingData, buildings, barriers, user.getId());
			buildProcesser.processNewBarriers(Constant.maxBarrierNum);
			
			barriers = buildProcesser.getBarriers();
			for (Barrier barrier : barriers) {
				if(barrier.getId() == null)
					barrierMapper.insertSelective(barrier);
			}
			
			isNewUser = true;
		}else{
			user = userMapper.selectByPrimaryKey(platformUser.getUserId());
			buildings.addAll(buildingMapper.findBuildingsByUserId(user.getId()));
			barriers = barrierMapper.findAllBarriersByUser(user.getId());
		}
		result.put("isNewUser", isNewUser);
		result.put("user", user);
		result.put("buildings", buildings);
		result.put("barriers", barriers);
		return result;
	}
	
	@Override
	public Map<String, Object> deleteBarrier(Integer userId, String pos){
		Barrier barrier = barrierMapper.findBarrier(userId, Integer.valueOf(pos.split("_")[0]), Integer.valueOf(pos.split("_")[1]));
		if(barrier == null){
			throw new BusinessException(ErrorCode.NotExistBarrier, String.format("userId(%d),pos(%s) barrier not exist!", userId, pos));
		}
		
		HashMap<String, Object> ret = new HashMap<>();
		User user = userMapper.selectByPrimaryKey(userId);
		if(barrierMapper.deleteByPrimaryKey(barrier.getId())> 0){
			int clearBarriersNum = user.getClearBarriersNum() + 1;
			if(clearBarriersNum < 0 ){
				clearBarriersNum = 0;
			}
			BuildElemet buildElemet = buildingData.findBuildElement(barrier.getXmlId());
			user.setClearBarriersNum(clearBarriersNum);
			int extraDima = new Random().nextInt(Constant.getDimaond(user.getClearBarriersNum()));
			user.setDimaond(user.getDimaond() + extraDima);
			user.setFame(user.getFame() + buildElemet.getFame());
			userMapper.updateByPrimaryKey(user);
			ret.put("extraDima", extraDima);
			ret.put("user", user);
		}
		return ret;
	}
}
