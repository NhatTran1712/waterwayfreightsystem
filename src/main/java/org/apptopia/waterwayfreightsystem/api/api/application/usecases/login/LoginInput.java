package org.apptopia.waterwayfreightsystem.api.api.application.usecases.login;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseInput;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder 
@AllArgsConstructor @NoArgsConstructor
public class LoginInput implements UseCaseInput {
	private String username;
}
