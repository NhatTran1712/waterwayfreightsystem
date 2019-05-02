package org.apptopia.waterwayfreightsystem.api.api;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RegisterAccountUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate.UpdateAccountUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	private UpdateAccountUseCase updateAccountUseCase;
	
	@Autowired
	public void setAccountUseCase(RegisterAccountUseCase registerAccountUseCase,
		UpdateAccountUseCase updateAccountUseCase) {
		
		this.registerAccountUseCase = registerAccountUseCase;
		this.updateAccountUseCase = updateAccountUseCase;
	}
	
	@RequestMapping(value = {"/register-customer-account/","/register-customer-account"},
		produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.POST)
	@ResponseBody
	public RawAccountOutput addNewCustomerAccount(@RequestBody RawAccountInput rawAccountInput){
		return registerAccountUseCase.handle(rawAccountInput);
	}
	
	@RequestMapping(value = {"/register-staff-account","/register-staff-account/"},
		produces = "application/json", consumes = MediaType.APPLICATION_JSON_VALUE,
		method = RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public RawAccountOutput addNewStaffAccount(@RequestBody RawAccountInput rawAccountInput){
		return registerAccountUseCase.handle(rawAccountInput);
	}
	
	@RequestMapping(value = {"/update/","/update"}, produces = "application/json",
			consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	@ResponseBody
	public RawAccountOutput updateAccount(@RequestBody RawAccountInput rawAccountInput) {
		return updateAccountUseCase.handle(rawAccountInput);
	}
	
}
