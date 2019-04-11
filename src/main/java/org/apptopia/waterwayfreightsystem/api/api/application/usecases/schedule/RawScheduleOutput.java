package org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule;

import java.time.LocalDateTime;
import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;
import org.apptopia.waterwayfreightsystem.api.api.port.model.Port;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class RawScheduleOutput implements UseCaseOutput {
	
	private Integer idSchedule;
	private List<Port> visitingPorts;
	private Integer estimateDistance;
	private Integer estimateTime;
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	private LocalDateTime dateDepart;
	@JsonDeserialize(using=LocalDateTimeDeserializer.class)
	private LocalDateTime dateArrive;
	private Integer whoManage;
}
