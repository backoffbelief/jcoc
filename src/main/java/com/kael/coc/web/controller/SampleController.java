package com.kael.coc.web.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("/sample")
public class SampleController {
	private static final Logger logger = Logger
			.getLogger(SampleController.class);

	@RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
	public @ResponseBody
	String hello() {
		return "hello world!";
	}

	@RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String say(@PathVariable(value = "msg") String msg) {
		return "{\"msg\":\"you say:'" + msg + "'\"}";
	}
/**
	@RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody
	Object getPerson(@PathVariable("id") int id) {
		logger.info("获取人员信息id=" + id);
		Person person = new Person();
		person.setName("张三");
		person.setSex("男");
		person.setAge(30);
		person.setId(id);
		return JSON.toJSONString(person, true);
	}
*/
	@RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.DELETE)
	public @ResponseBody
	Object deletePerson(@PathVariable("id") int id) {
		logger.info("删除人员信息id=" + id);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "删除人员信息成功");
		return jsonObject.toString();
	}
/**
	@RequestMapping(value = "/person", method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/json;charset=UTF-8")
	public @ResponseBody
	Object addPerson(Person person) {
		logger.info("注册人员信息成功id=" + person.getId());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "注册人员信息成功");
		return jsonObject.toString();
	}

	@RequestMapping(value = "/person", method = RequestMethod.PUT)
	public @ResponseBody
	Object updatePerson(Person person) {
		logger.info("更新人员信息id=" + person.getId());
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", "更新人员信息成功");
		return jsonObject;
	}

	@RequestMapping(value = "/person/list", method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String listPerson(
			@RequestParam(value = "name", required = false, defaultValue = "") String name) {

		logger.info("查询人员name like " + name);
		List<Person> lstPersons = new ArrayList<Person>();

		Person person = new Person();
		person.setName("张三");
		person.setSex("男");
		person.setAge(25);
		person.setId(101);
		lstPersons.add(person);

		Person person2 = new Person();
		person2.setName("李四");
		person2.setSex("女");
		person2.setAge(23);
		person2.setId(102);
		lstPersons.add(person2);

		Person person3 = new Person();
		person3.setName("王五");
		person3.setSex("男");
		person3.setAge(27);
		person3.setId(103);
		lstPersons.add(person3);

		return JSON.toJSONString(lstPersons, true);
	}
	*/
}
