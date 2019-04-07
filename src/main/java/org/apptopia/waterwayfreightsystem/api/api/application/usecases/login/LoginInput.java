package org.apptopia.waterwayfreightsystem.api.api.application.usecases.login;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseInput;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class LoginInput implements UseCaseInput {
	private String username;
}
