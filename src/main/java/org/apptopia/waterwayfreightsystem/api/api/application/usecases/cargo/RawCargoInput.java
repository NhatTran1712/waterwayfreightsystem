package org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class RawCargoInput implements UseCaseInput {
	private Integer idCargo;
	private Long idOwner;
	private Float cargoWeight;
}
