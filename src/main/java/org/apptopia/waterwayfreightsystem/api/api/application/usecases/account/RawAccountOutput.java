package org.apptopia.waterwayfreightsystem.api.api.application.usecases.account;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RawAccountOutput implements UseCaseOutput{

	private String username;
    private AccountType accountType;
	private String fullname;
	private String address;
	private String phoneNumber;
	private String idCard;
}
