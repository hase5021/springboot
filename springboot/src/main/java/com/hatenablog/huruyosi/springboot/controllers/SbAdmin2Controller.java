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

	@RequestMapping("/buttons.html")
	public ModelAndView buttons() {
		return new ModelAndView("SbAdmin2Controller/buttons");
	}
	
	@RequestMapping("/blank.html")
	public ModelAndView blank() {
		return new ModelAndView("SbAdmin2Controller/blank");
	}

	@RequestMapping("/flot.html")
	public ModelAndView flat() {
		return new ModelAndView("SbAdmin2Controller/flot");
	}

	@RequestMapping("/forms.html")
	public ModelAndView forms() {
		return new ModelAndView("SbAdmin2Controller/forms");
	}

}
