package org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseInput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class RawTravelProblemInput implements UseCaseInput {
	private Integer idTravelProblem;
	private String description;
	private Float timeExtend;
	private Integer distanceExtend;
	private Long whoManage;
}
