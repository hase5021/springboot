package com.hatenablog.huruyosi.springboot.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sbadmin2/")
@Secured("IS_AUTHENTICATED_FULLY")
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

	@Secured("ROLE_STAFF")
	@RequestMapping("/forms.html")
	public ModelAndView forms() {
		return new ModelAndView("SbAdmin2Controller/forms");
	}

	@RequestMapping("/grid.html")
	public ModelAndView grid() {
		return new ModelAndView("SbAdmin2Controller/grid");
	}

	@RequestMapping("/icons.html")
	public ModelAndView icons() {
		return new ModelAndView("SbAdmin2Controller/icons" );
	}

	@RequestMapping("/login.html")
	public ModelAndView login() {
		return new ModelAndView("SbAdmin2Controller/login" );
	}
	
	@RequestMapping("/morris.html")
	public ModelAndView morris() {
		return new ModelAndView("SbAdmin2Controller/morris" );
	}
	
	@RequestMapping("/notifications.html")
	public ModelAndView notifications() {
		return new ModelAndView("SbAdmin2Controller/notifications" );
	}
	
	@RequestMapping("/panels-wells.html")
	public ModelAndView panelsWells() {
		return new ModelAndView("SbAdmin2Controller/panels-wells" );
	}

	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/tables.html")
	public ModelAndView tables() {
		return new ModelAndView("SbAdmin2Controller/tables" );
	}
	
	@RequestMapping("/typography.html")
	public ModelAndView typography() {
		return new ModelAndView("SbAdmin2Controller/typography" );
	}
}
