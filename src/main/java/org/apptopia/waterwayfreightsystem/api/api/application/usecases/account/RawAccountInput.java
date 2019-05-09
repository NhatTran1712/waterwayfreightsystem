package org.apptopia.waterwayfreightsystem.api.api.application.usecases.account;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseInput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @Builder @NoArgsConstructor
public class RawAccountInput implements UseCaseInput {
	
    private Long idUser;
	private String username;
	private String password;
	private AccountType accountType;
	private String fullname;
	private String address;
	private String phoneNumber;
	private String idCard;
}
