package org.apptopia.waterwayfreightsystem.api.api.application.usecases.location;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RawCityOutput implements UseCaseOutput {
	private Long idCity;
	private String name;
}
