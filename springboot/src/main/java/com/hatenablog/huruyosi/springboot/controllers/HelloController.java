package com.hatenablog.huruyosi.springboot.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello world";
	}
	
	@RequestMapping("/thymeleaf")
	public ModelAndView thymeleaf() {
		Map<String, String> model = new HashMap<String, String>();
		model.put("message", "hello world");
		return new ModelAndView("HelloController/thymeleaf", model);
	}
}
