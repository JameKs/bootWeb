package com.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bean.User;

@RestController
@RequestMapping(value="/index")
public class IndexController {
	
	@RequestMapping
	public String index(){
		return "Hello World!";
	}
	
	@RequestMapping(value="get")
	public Map<String,String> get(@RequestParam String name,@RequestParam int age){
		Map<String,String> map = new HashMap<String, String>();
		map.put("name:", name);
		map.put("age:", ""+age);
		return map;
	}
	
	@RequestMapping(value="find/{name}/{age}")
	public User findUser(@PathVariable String name,@PathVariable int age){
		User user = new User();
		user.setUserName(name);
		user.setUserAge(age);
		user.setDate(new Date());
		return user;
	}
}
