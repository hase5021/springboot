package com.hatenablog.huruyosi.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping(value="/login")
	public String login(){
		return "/SbAdmin2Controller/login";
	}
}
