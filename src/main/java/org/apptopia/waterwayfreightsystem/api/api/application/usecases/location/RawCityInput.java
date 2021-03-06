package org.apptopia.waterwayfreightsystem.api.api.application.usecases.location;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RawCityInput implements UseCaseInput{
	private Long idCity;
	private String name;
}
