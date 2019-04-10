package org.apptopia.waterwayfreightsystem.api.api.applications.usecases.login;

import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.UseCaseInput;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @AllArgsConstructor @Builder
public class LoginInput implements UseCaseInput {
	private String username;
}
