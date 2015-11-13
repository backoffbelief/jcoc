package com.kael.coc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kael.coc.bo.UserLoginProcesser;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value = "/getUserInfo/{platformId}", method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getUserInfo(@PathVariable("platformId")String platformId){
		UserLoginProcesser processer = new UserLoginProcesser(platformId);
		processer.processerLogin();
		return processer.result();
	}
}
