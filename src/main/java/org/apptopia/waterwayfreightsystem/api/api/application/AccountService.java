package org.apptopia.waterwayfreightsystem.api.api.application;

import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.addaccount.RawAccountInput;
import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.addaccount.RawAccountOutput;

public interface AccountService {
	
	RawAccountOutput newAccount(RawAccountInput rawAccountInput);
}
