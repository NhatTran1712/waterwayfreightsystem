package org.apptopia.waterwayfreightsystem.api.api.authentication.core.model;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignUpForm {
	@NotBlank
    @Size(min = 2, max = 20)
    private String username;
	@NotBlank
	private String password;
	@NotBlank
    private String passwordConfirm;
    private Set<String> role;
    @NotBlank
    @Size(min = 1, max = 25)
    private String fullname;
	private String address;
	@NotBlank
	private String phoneNumber;
	@NotBlank
	private String idCard;
}
