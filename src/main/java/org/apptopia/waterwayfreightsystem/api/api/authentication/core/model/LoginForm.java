package org.apptopia.waterwayfreightsystem.api.api.authentication.core.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LoginForm {
	@NotBlank
    @Size(min=2, max = 20)
	private String username;
	@NotBlank
    private String password;
}
