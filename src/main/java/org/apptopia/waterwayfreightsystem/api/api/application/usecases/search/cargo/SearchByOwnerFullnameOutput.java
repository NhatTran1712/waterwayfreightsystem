package org.apptopia.waterwayfreightsystem.api.api.application.usecases.search.cargo;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.cargo.RawCargoOutput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
@AllArgsConstructor
public class SearchByOwnerFullnameOutput implements UseCaseOutput {
	private List<RawCargoOutput> rawCargoOutputs;
}
