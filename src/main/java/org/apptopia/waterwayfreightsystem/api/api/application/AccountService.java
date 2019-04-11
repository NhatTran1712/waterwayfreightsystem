package org.apptopia.waterwayfreightsystem.api.api.application;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountOutput;

public interface AccountService {
	
	RawAccountOutput newAccount(RawAccountInput rawAccountInput);
	RawAccountOutput updateAccount(Integer idAccount, RawAccountInput rawAccountInput);
}
