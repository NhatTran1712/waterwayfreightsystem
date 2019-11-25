package org.apptopia.waterwayfreightsystem.api.api.application.usecases.account;

import java.util.Set;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RawAccountOutput implements UseCaseOutput{
	
//	private Long idUser;
	private String username;
    private Set<String> role;
	private String fullname;
	private String address;
	private String phoneNum;
	private String idCard;
}
