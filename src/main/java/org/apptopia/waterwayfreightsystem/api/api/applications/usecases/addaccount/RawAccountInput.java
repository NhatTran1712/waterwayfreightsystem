package org.apptopia.waterwayfreightsystem.api.api.applications.usecases.addaccount;

import org.apptopia.waterwayfreightsystem.api.api.applications.usecases.UseCaseInput;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data @AllArgsConstructor @Builder
public class RawAccountInput implements UseCaseInput {
	
    private Integer idUser;
	private String username;
	private String password;
	private String fullname;
	private String address;
	private String phoneNumber;
	private String idCard;
}
