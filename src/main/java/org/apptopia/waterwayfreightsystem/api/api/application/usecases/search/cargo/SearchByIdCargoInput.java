package org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class SearchByIdCargoInput implements UseCaseInput {
	private Long idCargo;
	private String ownerUsername;
}
