package org.apptopia.waterwayfreightsystem.api.api.application.usecases.account;

import org.apptopia.waterwayfreightsystem.api.api.application.AccountService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterAccountUseCase implements UseCase<RawAccountInput, RawAccountOutput> {
	
	@Autowired AccountService accountService;
	
	@Override
	public RawAccountOutput handle(RawAccountInput rawAccountInput) {
		return accountService.newAccount(rawAccountInput);
	}

}
