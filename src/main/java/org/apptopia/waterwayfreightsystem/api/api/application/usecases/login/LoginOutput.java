package org.apptopia.waterwayfreightsystem.api.api.application.usecases.login;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor 
public class LoginOutput implements UseCaseOutput {
	private String username;
	private AccountType accountType;
}
