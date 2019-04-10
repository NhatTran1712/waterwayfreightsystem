package org.apptopia.waterwayfreightsystem.api.api.applications.usecases.addaccount;

import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.UseCaseOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class RawAccountOutput implements UseCaseOutput{

	private String username;
    private AccountType accountType;
	private String fullname;
	private String address;
	private String phoneNumber;
	private String idCard;
}
