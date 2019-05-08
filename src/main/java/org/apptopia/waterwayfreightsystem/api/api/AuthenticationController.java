package org.apptopia.waterwayfreightsystem.api.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin
public class AuthenticationController {

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        
    	if (error != null) {
            model.addAttribute("error", "Username va password khong dung.");
    	}
        if (logout != null) {
            model.addAttribute("message", "Ban da dang xuat thanh cong.");
        }
        return "login";
    }
}
