package org.apptopia.waterwayfreightsystem.api.api.application;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.account.AccountRepository;
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
	public void initDataSchedule() {
		List<Schedule> schedules = scheduleRepository.findAll();
		
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
			Optional<Schedule> existingSchedule = scheduleRepository.findByNameSchedule
					("quang ninh - hai phong");
			
			if(!existingSchedule.isPresent()) {
				visitingPorts1.add(existing1.get());
				visitingPorts1.add(existing2.get());
				Schedule schedule1 = Schedule.builder()
					.idSchedule(null)
					.nameSchedule("quang ninh - hai phong")
					.visitingPorts(visitingPorts1)
					.estimateDistance(6000)
					.estimateTime(48)
					.dateDepart(LocalDateTime.now())
					.dateArrive(LocalDateTime.now().plusDays(2))
					.whoManage(existingOne.get())
					.build();
				scheduleRepository.save(schedule1);
			}
			existingSchedule = scheduleRepository.findByNameSchedule("nam dinh - thai binh");
			
			if(!existingSchedule.isPresent()) {
				visitingPorts2.add(existing3.get());
				visitingPorts2.add(existing4.get());
				System.out.println("vsiting2 " + visitingPorts2.toString());
				Schedule schedule2 = Schedule.builder()
					.idSchedule(null)
					.nameSchedule("nam dinh - thai binh")
					.visitingPorts(visitingPorts2)
					.estimateDistance(7000)
					.estimateTime(72)
					.dateDepart(LocalDateTime.now().plusDays(1))
					.dateArrive(LocalDateTime.now().plusDays(4))
					.whoManage(existingOne.get())
					.build();
				scheduleRepository.save(schedule2);
			}
		}
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
	public List<RawScheduleOutput> findScheduleByNameSchedule(String nameSchedule) {
		List<Schedule> schedules = scheduleRepository.findByNameScheduleContaining(nameSchedule);
		List<RawScheduleOutput> rawScheduleOutputs = new ArrayList<>();
		RawScheduleOutput rawScheduleOutput = new RawScheduleOutput();
		
		for(Schedule schedule : schedules) {
			rawScheduleOutput = RawScheduleMapper.INSTANCE.fromSchedule(schedule);
			rawScheduleOutput.setIdWhoManage(RawScheduleMapper.INSTANCE.fromAccount(schedule.
				getWhoManage()));
			rawScheduleOutputs.add(rawScheduleOutput);
		}
		return rawScheduleOutputs;
	}

	@Override
	public RawScheduleOutput findScheduleByIdSchedule(Long idSchedule) {
		Optional<Schedule> existingOne = scheduleRepository.findById(idSchedule);
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Schedule not existed");
		}
		Schedule schedule = existingOne.get();
		RawScheduleOutput rawScheduleOutput = RawScheduleMapper.INSTANCE.fromSchedule(schedule);
		
		rawScheduleOutput.setIdWhoManage(RawScheduleMapper.INSTANCE.fromAccount(schedule.getWhoManage()));
		return rawScheduleOutput;
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

	@Override
	public RawScheduleOutput deleteSchedule(Long idSchedule) {
		Optional<Schedule> existingOne = scheduleRepository.findById(idSchedule);
		RawScheduleOutput rawScheduleOutput = new RawScheduleOutput();
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Schedule not existed");
		}
		Schedule schedule = existingOne.get();
		
		scheduleRepository.deleteById(idSchedule);
		rawScheduleOutput = RawScheduleMapper.INSTANCE.fromSchedule(schedule);
		rawScheduleOutput.setIdWhoManage(RawScheduleMapper.INSTANCE.fromAccount(schedule.getWhoManage()));
		System.out.println("Delete " + schedule.getNameSchedule() + " successful!");
		return rawScheduleOutput;
	}
}
