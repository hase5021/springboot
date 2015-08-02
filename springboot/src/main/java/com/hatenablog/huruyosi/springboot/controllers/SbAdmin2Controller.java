package com.hatenablog.huruyosi.springboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sbadmin2/")
public class SbAdmin2Controller {

	@RequestMapping("/index.html")
	public ModelAndView index() {
		return new ModelAndView("SbAdmin2Controller/index");
	}

	@RequestMapping("/blank.html")
	public ModelAndView blank() {
		return new ModelAndView("SbAdmin2Controller/blank");
	}
}
