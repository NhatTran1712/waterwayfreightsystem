package org.apptopia.waterwayfreightsystem.api.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin
public class ApplicationController {
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String homePage(Model model) {
		return "home";
	}
	
	@RequestMapping(value = {"/home-admin/","/home-admin"}, method = RequestMethod.GET)
	public String homeAdminPage(Model model) {
		return "home-admin";
	}
	
	@RequestMapping(value = {"/home-manager/","/home-manager"}, method = RequestMethod.GET)
	public String homeManagerPage(Model model) {
		return "home-manager";
	}
}
