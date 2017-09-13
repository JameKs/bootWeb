package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/templetes")
public class TempletesController {
	
	@RequestMapping(value="thymeleaf")
	public String thymeleaf(){
		return "thymeleaf";
	}
}
