package org.apptopia.waterwayfreightsystem.api.api;

import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.addaccount.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.addaccount.RawAccountOutput;
import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.addaccount.RegisterAccountUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {
	
	private RegisterAccountUseCase registerAccountUseCase;
	
	@Autowired
	public void setAccountService(RegisterAccountUseCase registerAccountUseCase) {
		
		this.registerAccountUseCase = registerAccountUseCase;
	}
	
	@RequestMapping(value = {"/",""}, produces = "application/json",
			consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RawAccountOutput addNewCustomerAccount(@RequestBody RawAccountInput rawAccountInput){
		return registerAccountUseCase.handle(rawAccountInput);
	}
	
	@RequestMapping(value = {"/register-staff-account","/register-staff-account/"},
			produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	@ResponseBody
	public RawAccountOutput addNewStaffAccount(@RequestBody RawAccountInput rawAccountInput){
		return registerAccountUseCase.handle(rawAccountInput);
	}
	
}
