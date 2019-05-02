package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleOutput;

public interface ScheduleService {
	
	List<RawScheduleOutput> findAllSchedules();
	RawScheduleOutput newSchedule(RawScheduleInput rawScheduleInput);
	RawScheduleOutput updateSchedule(RawScheduleInput rawScheduleInput);
}
