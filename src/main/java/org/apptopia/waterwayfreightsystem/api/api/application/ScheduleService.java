package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleOutput;

public interface ScheduleService {
	
	void initDataSchedule();
	List<RawScheduleOutput> findAllSchedules();
	List<RawScheduleOutput> findScheduleByNameSchedule(String nameSchedule);
	RawScheduleOutput findScheduleByIdSchedule(Long idSchedule);
	RawScheduleOutput newSchedule(RawScheduleInput rawScheduleInput);
	RawScheduleOutput updateSchedule(RawScheduleInput rawScheduleInput);
	RawScheduleOutput deleteSchedule(Long idSchedule);
}
