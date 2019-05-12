package org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class RawCargoOutput implements UseCaseOutput {
	private Long idCargo;
	private Long idOwner;
	private Float cargoWeight;
}
