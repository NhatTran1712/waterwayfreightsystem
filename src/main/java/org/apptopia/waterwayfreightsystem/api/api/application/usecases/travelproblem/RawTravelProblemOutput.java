package org.apptopia.waterwayfreightsystem.api.api.application.usecases.travelproblem;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class RawTravelProblemOutput implements UseCaseOutput {
	private Integer idTravelProblem;
	private String description;
	private Float timeExtend;
	private Integer distanceExtend;
	private Integer whoManage;
}
