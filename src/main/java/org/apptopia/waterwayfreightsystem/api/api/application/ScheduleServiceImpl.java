package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
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
	public List<RawScheduleOutput> findAllSchedules() {
		List<Schedule> schedules = scheduleRepository.findAll();
		List<RawScheduleOutput> rawScheduleOutputs = new ArrayList<>();
		
		for(Schedule schedule : schedules){
			rawScheduleOutputs.add(RawScheduleMapper.INSTANCE.fromSchedule(schedule));
		}
		return rawScheduleOutputs;
	}

	@Override
	public RawScheduleOutput newSchedule(RawScheduleInput rawScheduleInput) {
		Schedule schedule = RawScheduleMapper.INSTANCE.fromRawInput(rawScheduleInput);
		Account account = RawScheduleMapper.INSTANCE.toAccount(rawScheduleInput.getWhoManage());
		schedule.setWhoManage(account);
		scheduleRepository.save(schedule);
		return RawScheduleMapper.INSTANCE.fromSchedule(schedule);
	}

}
