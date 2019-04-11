package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleOutput;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Schedule;
import org.apptopia.waterwayfreightsystem.api.api.core.model.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	private ScheduleRepository scheduleRepository;
	
	@Autowired
	public void setScheduleService(@Qualifier("PostgresScheduleRepository")
		ScheduleRepository scheduleRepository) {
		this.scheduleRepository = scheduleRepository;
	}
	
	@Override
	public List<RawScheduleOutput> getAllSchedules() {
		List<Schedule> schedules = scheduleRepository.findAll();
		List<RawScheduleOutput> rawScheduleOutputs = new ArrayList<>();
		
		for(Schedule schedule : schedules){
			rawScheduleOutputs.add(RawScheduleMapper.INSTANCE.fromSchedule(schedule));
		}
		return rawScheduleOutputs;
	}

}
