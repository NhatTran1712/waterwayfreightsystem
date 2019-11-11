package org.apptopia.waterwayfreightsystem.api.api.application.usecases.location;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RawDistrictOutput implements UseCaseOutput {
	private Long idDist;
	private String name;
}
