package com.kael.coc.bo;

import com.kael.coc.data.UserDB;

public class UserLoginProcesser {

	private String platformId;
	private boolean newUser;
	private boolean todayFirstLogin;

	public UserLoginProcesser(String plaformId) {
		super();
		this.platformId = plaformId;
	}
	
	public void processerLogin(){
		newUser = !UserDB.contains(platformId);
		if(newUser){
			todayFirstLogin = true;
			User user = new User();
			user.setUserId(UserDB.getUniqeId());
			user.setFame(100);
			user.setRank(1);
			user.setDimaond(250);
			user.setPlatformId(platformId);
			user.setLastLoginTime(System.currentTimeMillis());
			UserDB.addPlat2UserId(platformId, user.getUserId());
			
			WrapUserData userData = new WrapUserData();
			
		}
	}
	
}
