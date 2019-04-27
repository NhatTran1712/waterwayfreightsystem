package org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class RawCargoOutput implements UseCaseOutput {
	private Integer idOwner;
	private Float cargoWeight;
}
