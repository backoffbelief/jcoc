package com.kael.coc.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.kael.coc.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getUserInfo/{platformId}", method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/json;charset=UTF-8")
	public @ResponseBody String getUserInfo(@PathVariable("platformId")String platformId){
		return JSON.toJSONString(userService.getUserInfo(platformId), true);
	}
	
	@RequestMapping(value="/deleteBarrier/{userId}/{pos}", method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/json;charset=UTF-8")
	public @ResponseBody String deleteBarrier(@PathVariable("userId")Integer userId, @PathVariable("pos") String pos){
		return JSON.toJSONString(userService.deleteBarrier(userId, pos), true);
	}
	@RequestMapping(value="/upgradeBuilding/{userId}/{buildId}", method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/json;charset=UTF-8")
	public @ResponseBody String upgradeBuilding(@PathVariable("userId")Integer userId, @PathVariable("buildId") Integer buildId){
		return JSON.toJSONString(userService.upgradeBuilding(userId, buildId), true);
	}
	
}
