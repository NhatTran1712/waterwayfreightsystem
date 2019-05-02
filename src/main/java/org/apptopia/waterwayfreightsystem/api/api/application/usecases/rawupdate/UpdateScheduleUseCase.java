package org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate;

import org.apptopia.waterwayfreightsystem.api.api.application.ScheduleService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateScheduleUseCase implements UseCase<RawScheduleInput,RawScheduleOutput> {
	@Autowired ScheduleService scheduleService;
	
	@Override
	public RawScheduleOutput handle(RawScheduleInput rawScheduleInput) {
		return scheduleService.updateSchedule(rawScheduleInput);
	}
	
}
