package org.apptopia.waterwayfreightsystem.api.api.authentication.core.model;

import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class SignUpForm implements UseCaseInput {
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
    @NotBlank
    private Long cityId;
    @NotBlank
    private Long districtId;
	private String address;
	@NotBlank
	private String phoneNum;
	@NotBlank
	private String idCard;
}
