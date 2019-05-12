package org.apptopia.waterwayfreightsystem.api.api.application.usecases.search;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class SearchByOwnerFullnameInput implements UseCaseInput{
	private String ownerFullname;

}
