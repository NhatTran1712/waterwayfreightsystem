package org.apptopia.waterwayfreightsystem.api.api.application.usecases.account;

import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseInput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RawAccountInput implements UseCaseInput {
    private Long idUser;
    @NotBlank
    @Size(min = 2, max = 20)
	private String username;
    @NotBlank
	private String password;
    @NotBlank
    private String passConfirm;
    private Set<String> role;
    @NotBlank
    @Size(min = 1, max = 25)
    private String fullname;
    @NotBlank
    private Long idCity;
    @NotBlank
    private Long idDist;
    private String address;
	@NotBlank
	private String phoneNum;
	@NotBlank
	private String idCard;
}
