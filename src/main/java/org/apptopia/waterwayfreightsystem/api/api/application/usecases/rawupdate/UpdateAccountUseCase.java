package org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate;

import org.apptopia.waterwayfreightsystem.api.api.application.AccountService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateAccountUseCase implements UseCase<RawAccountInput, RawAccountOutput> {
	
	@Autowired AccountService accountService;

	@Override
	public RawAccountOutput handle(RawAccountInput rawAccountInput) {
		return accountService.updateAccount(rawAccountInput);
	}

}
