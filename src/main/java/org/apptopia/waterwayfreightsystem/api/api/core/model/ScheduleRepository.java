package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.util.List;

public interface ScheduleRepository {
	
	Schedule save(Schedule schedule);
	List<Schedule> findAll();
}
