package org.apptopia.waterwayfreightsystem.api.api.application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountRepository;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Schedule;
import org.apptopia.waterwayfreightsystem.api.api.core.model.ScheduleRepository;
import org.apptopia.waterwayfreightsystem.api.api.port.model.Port;
import org.apptopia.waterwayfreightsystem.api.api.port.model.PortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {
	private ScheduleRepository scheduleRepository;
	private PortRepository portRepository;
	private AccountRepository accountRepository;
	
	@Autowired
	public void setScheduleRepository(@Qualifier("PostgresScheduleRepository")
		ScheduleRepository scheduleRepository, @Qualifier("PostgresPortRepository")
		PortRepository portRepository, AccountRepository accountRepository) {
		
		this.scheduleRepository = scheduleRepository;
		this.portRepository = portRepository;
		this.accountRepository = accountRepository;
	}
	
	@Override
	public List<RawScheduleOutput> initDataSchedule() {
		List<Schedule> schedules = scheduleRepository.findAll();
		List<RawScheduleOutput> rawScheduleOutputs = new ArrayList<>();
		RawScheduleOutput rawScheduleOutput = new RawScheduleOutput();
		
		if(schedules.size()<2) {
			Optional<Port> existing1 = portRepository.findByNamePort("Ben cang xang dau Cai Lan");
			Optional<Port> existing2 = portRepository.findByNamePort("Ben cang Nam Ninh");
			Optional<Port> existing3 = portRepository.findByNamePort("Ben cang Thinh Long");
			Optional<Port> existing4 = portRepository.findByNamePort
				("Ben cang xuat nhap xang dau Hai Ha");
			System.out.println("ex3: " + existing3.get().toString());
			System.out.println("ex3: " + existing4.get().toString());
			List<Port> visitingPorts1 = new ArrayList<>();
			List<Port> visitingPorts2 = new ArrayList<>();
			Optional<Account> existingOne = accountRepository.findByUsername("manager");
			
			visitingPorts1.add(existing1.get());
			visitingPorts1.add(existing2.get());
			Schedule schedule1 = Schedule.builder()
				.idSchedule(null)
				.visitingPorts(visitingPorts1)
				.estimateDistance(6000)
				.estimateTime(48)
				.dateDepart(LocalDateTime.now())
				.dateArrive(LocalDateTime.now().plusDays(2))
				.whoManage(existingOne.get())
				.build();
			scheduleRepository.save(schedule1);
			rawScheduleOutput = RawScheduleMapper.INSTANCE.fromSchedule(schedule1);
			rawScheduleOutput.setIdWhoManage(RawScheduleMapper.INSTANCE.fromAccount(schedule1.
				getWhoManage()));
			rawScheduleOutputs.add(rawScheduleOutput);
			visitingPorts2.add(existing3.get());
			visitingPorts2.add(existing4.get());
			System.out.println("vsiting2 " + visitingPorts2.toString());
			Schedule schedule2 = Schedule.builder()
				.idSchedule(null)
				.visitingPorts(visitingPorts2)
				.estimateDistance(7000)
				.estimateTime(72)
				.dateDepart(LocalDateTime.now().plusDays(1))
				.dateArrive(LocalDateTime.now().plusDays(4))
				.whoManage(existingOne.get())
				.build();
			scheduleRepository.save(schedule2);
			rawScheduleOutput = RawScheduleMapper.INSTANCE.fromSchedule(schedule2);
			rawScheduleOutput.setIdWhoManage(RawScheduleMapper.INSTANCE.fromAccount(schedule2.
				getWhoManage()));
			rawScheduleOutputs.add(rawScheduleOutput);
		}
		return rawScheduleOutputs;
	}
	
	@Override
	public List<RawScheduleOutput> findAllSchedules() {
		List<Schedule> schedules = scheduleRepository.findAll();
		List<RawScheduleOutput> rawScheduleOutputs = new ArrayList<>();
		RawScheduleOutput rawScheduleOutput = new RawScheduleOutput();
		
		for(Schedule schedule : schedules){
			rawScheduleOutput = RawScheduleMapper.INSTANCE.fromSchedule(schedule);
			rawScheduleOutput.setIdWhoManage(RawScheduleMapper.INSTANCE.fromAccount(schedule.
				getWhoManage()));
			rawScheduleOutputs.add(rawScheduleOutput);
		}
		return rawScheduleOutputs;
	}

	@Override
	public RawScheduleOutput newSchedule(RawScheduleInput rawScheduleInput) {
		Schedule schedule = RawScheduleMapper.INSTANCE.fromRawInput(rawScheduleInput);
		Account account = RawScheduleMapper.INSTANCE.toAccount(rawScheduleInput.getIdWhoManage());
		schedule.setWhoManage(account);
		scheduleRepository.save(schedule);
		return RawScheduleMapper.INSTANCE.fromSchedule(schedule);
	}

	@Override
	public RawScheduleOutput updateSchedule(RawScheduleInput rawScheduleInput) {
		Optional<Schedule> existingOne = scheduleRepository.findById(
			rawScheduleInput.getIdSchedule());
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Schedule not existed");
		}
		Schedule schedule = RawScheduleMapper.INSTANCE.fromRawInput(rawScheduleInput);
		scheduleRepository.save(schedule);
		return RawScheduleMapper.INSTANCE.fromSchedule(schedule);
	}
}
