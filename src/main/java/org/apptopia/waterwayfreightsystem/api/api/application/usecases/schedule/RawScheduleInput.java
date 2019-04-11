package org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule;

import java.time.LocalDateTime;
import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseInput;
import org.apptopia.waterwayfreightsystem.api.api.port.model.Port;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @Builder @NoArgsConstructor
public class RawScheduleInput implements UseCaseInput{

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
