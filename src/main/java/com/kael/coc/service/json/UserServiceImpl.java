package com.kael.coc.service.json;

import java.util.HashMap;

import com.kael.coc.bo.UserLoginProcesser;
import com.kael.coc.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void getUserInfo(HashMap<String, String> args) {
		
		if(args == null || args.isEmpty())
		{
//			return ;
			throw new RuntimeException("");
		}
		String platformId = args.get("platformId");
		 UserLoginProcesser processer = new UserLoginProcesser(platformId);
			
	}

}
