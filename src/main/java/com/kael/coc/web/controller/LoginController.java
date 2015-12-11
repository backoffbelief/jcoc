package com.kael.coc.web.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kael.coc.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/getUserInfo/{platformId}", method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> getUserInfo(@PathVariable("platformId")String platformId){
		return userService.getUserInfo(platformId);
	}
	
	@RequestMapping(value="/deleteBarrier/{userId}/{pos}", method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> deleteBarrier(@PathVariable("userId")Integer userId, @PathVariable("pos") String pos){
		return userService.deleteBarrier(userId, pos);
	}
	@RequestMapping(value="/upgradeBuilding/{userId}/{buildId}", method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> upgradeBuilding(@PathVariable("userId")Integer userId, @PathVariable("buildId") Integer buildId){
		return userService.upgradeBuilding(userId, buildId);
	}
	
}
