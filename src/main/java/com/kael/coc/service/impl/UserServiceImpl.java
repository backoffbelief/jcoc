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
import com.kael.coc.bo.Cost;
import com.kael.coc.bo.PlatformUser;
import com.kael.coc.bo.Produce;
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
			user.setClearBarriersNum(0);
			userMapper.insert(user);
			
			platformUser = new PlatformUser();
			platformUser.setPlatformId(platformId);
			platformUser.setUserId(user.getId());
			
			platformUserMapper.insert(platformUser);
			BuildProcesser buildProcesser = new BuildProcesser(buildingData, buildings, barriers, user);
			
			buildingMapper.insertSelective(buildProcesser.processNewTownHall());
			
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
			BuildElemet buildElemet = buildingData.findBuildElement(barrier.getXmlId());
			int extraDima = Constant.getDimaond(user.getClearBarriersNum());
			int clearBarriersNum = user.getClearBarriersNum() + 1;
			if(clearBarriersNum < 0 ){
				clearBarriersNum = 0;
			}
			user.setClearBarriersNum(clearBarriersNum);
			user.setDimaond(user.getDimaond() + extraDima);
			user.setFame(user.getFame() + buildElemet.getFame());
			userMapper.updateByPrimaryKey(user);
			ret.put("extraDima", extraDima);
			ret.put("user", user);
		}
		return ret;
	}

	@Override
	public Map<String, Object> upgradeBuilding(Integer userId, Integer buildId) {
		Building building = buildingMapper.findBuildingByUserId(userId, buildId);
		if(building == null){
			throw new BusinessException(ErrorCode.NotExistBuilding, String.format("userId(%d),buildId(%d) barrier not exist!", userId, buildId));
		}
		BuildElemet buildElemet = buildingData.findBuildElement(building.getXmlId());
		if(buildElemet == null){
			throw new BusinessException(ErrorCode.NotExistBuildingElement,String.format("not exist building xmlId(%d)",building.getXmlId()));
		}
		if(buildElemet.getMaxLevel() <= building.getLevel()){
			throw new BusinessException(ErrorCode.ThisBuildingHasMaxLevel,String.format("this  building xmlId(%d),level(%d) is Maxed!",building.getXmlId(),building.getLevel()));
		}
		Produce produce = buildElemet.findProduce(building.getLevel(), TimeUtil.currentTimeMillis() -  building.getLastCollectTime().getTime());
		if(produce.getGoldNum() > 0){
			building.setLastCollectTime(new Date(TimeUtil.currentTimeMillis()));
		}
		
		User user = userMapper.selectByPrimaryKey(userId);
		Building town = buildingMapper.findBuildingsByUserIdAndXmlId(userId, Constant.TownHallXmlId).get(0);
		Cost cost = buildElemet.findCost(building.getLevel(), user, town);
		int dst = 0;
		if(cost.getGoldNum() > 0){
			List<Building>buildings  = buildingMapper.findBuildingsByUserId(userId);
			for (Building tmpBuild : buildings) {
				if(tmpBuild.getBuildId() == buildId){
					
				}
			}
		}
		List<Building> tmps = new ArrayList<Building>();
		
		return null;
	}
}
