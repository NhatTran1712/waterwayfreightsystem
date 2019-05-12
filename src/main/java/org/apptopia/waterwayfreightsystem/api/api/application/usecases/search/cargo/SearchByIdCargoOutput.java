package org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class SearchByIdCargoOutput implements UseCaseOutput {
	private RawCargoOutput rawCargoOutput;
}
