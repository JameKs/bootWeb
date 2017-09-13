package com.example.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bean.User;
import com.example.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/save")
	public String save(){
		User user = new User();
		user.setUserName("Jack");
		user.setUserAge(25);
		user.setDate(new Date()); 
		userService.save(user);
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
