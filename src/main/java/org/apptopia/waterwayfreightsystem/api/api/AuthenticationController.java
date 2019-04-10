package org.apptopia.waterwayfreightsystem.api.api;

import java.security.Principal;

import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.login.LoginInput;
import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.login.LoginOutput;
import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.login.LoginUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthenticationController {
	private LoginUseCase loginUseCase;
	
	@Autowired
	public void setLoginUseCase(LoginUseCase loginUseCase) {
		this.loginUseCase = loginUseCase;
	}
	
	@RequestMapping(value = {"/login","/login/"}, produces = "application/json",
			method = {RequestMethod.POST})
	@ResponseBody
	public LoginOutput login(Principal principal) {
		System.out.println("Principle: " + principal);
		if(principal==null) {
			return null;
		}
		System.out.println(principal.getName());
		LoginInput input = new LoginInput(principal.getName()); 
		System.out.println(loginUseCase.handle(input));
		return loginUseCase.handle(input);
	}
}
