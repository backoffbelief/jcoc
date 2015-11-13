package com.kael.coc.bo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kael.coc.data.UserDB;

public class UserLoginProcesser {

	private String platformId;
	private boolean newUser;
	private boolean todayFirstLogin;
	private WrapUserData userData;

	public UserLoginProcesser(String plaformId) {
		super();
		this.platformId = plaformId;
	}

	public void processerLogin() {
		newUser = !UserDB.contains(platformId);
		if (newUser) {
			todayFirstLogin = true;
			User user = new User();
			user.setUserId(UserDB.getUniqeId());
			user.setFame(100);
			user.setRank(1);
			user.setDimaond(250);
			user.setPlatformId(platformId);
			user.setLastLoginTime(System.currentTimeMillis());
			user.setBuildingId(0);
			UserDB.addPlat2UserId(platformId, user.getUserId());

			userData = new WrapUserData();
			userData.setUser(user);

			List<Building> buildings = new ArrayList<Building>();
			buildings.add(create(TownHall.class, 1, 0, 0, user.nextBuildingId()));
			
			userData.setBuildings(buildings);
			UserDB.saveDb(user.getUserId(), userData);
		}else{
			todayFirstLogin = false;
			userData = UserDB.getUser(platformId);
			List<Building> buildings = userData.getBuildings();
			boolean store = false;
			for (Building building : buildings) {
				store |= building.reflush();
			}
			if(store){
				UserDB.saveDb(userData.getUser().getUserId(), userData);
			}
		}
	}

	private Building create(Class<? extends Building> cls, int xmlId, int posX,
			int posY, int id) {
		try {
			Building b = cls.getConstructor().newInstance();
			b.setPosX(posX);
			b.setPosY(posY);
			b.setXmlId(xmlId);
			b.setId(id);
			b.setLevel(1);
			b.setCurrHp(100);
			return b;
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			// e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public String result() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("todayFirstLogin", todayFirstLogin);
		jsonObject.put("newUser", newUser);
		jsonObject.put("userData", userData);
		return JSON.toJSONString(jsonObject, true);
	}

}
