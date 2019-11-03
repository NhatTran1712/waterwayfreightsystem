package org.apptopia.waterwayfreightsystem.api.api.application.usecases.delete;

import org.apptopia.waterwayfreightsystem.api.api.application.ScheduleService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteScheduleUseCase implements UseCase<RawScheduleInput,RawScheduleOutput> {
	@Autowired ScheduleService scheduleService;
	
	@Override
	public RawScheduleOutput handle(RawScheduleInput input) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public RawScheduleOutput handle(Long idSchedule) {
		return scheduleService.deleteSchedule(idSchedule);
	}
}
