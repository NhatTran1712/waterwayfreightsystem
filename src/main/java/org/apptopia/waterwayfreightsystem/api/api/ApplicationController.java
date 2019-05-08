package org.apptopia.waterwayfreightsystem.api.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {
	
	@RequestMapping(value = {"/","/home"}, method = RequestMethod.GET)
	public String homePage(Model model) {
		return "home";
	}
}
