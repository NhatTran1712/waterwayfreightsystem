package org.apptopia.waterwayfreightsystem.api.api;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.ScheduleService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput.AddNewScheduleUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/schedule")
public class ScheduleController {
	private ScheduleService scheduleService;
	private AddNewScheduleUseCase addNewScheduleUseCase;
	
	@Autowired
	public void setScheduleService(ScheduleService scheduleService,
		AddNewScheduleUseCase addNewScheduleUseCase) {
		this.scheduleService = scheduleService;
		this.addNewScheduleUseCase = addNewScheduleUseCase;
	}
	
	@RequestMapping(value = {"/",""}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	public List<RawScheduleOutput> getAllSchedules(){
		return scheduleService.findAllSchedules();
	}
	
	@RequestMapping(value = {"/add","/new/"}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RawScheduleOutput addNewSchedule(@RequestBody RawScheduleInput rawScheduleInput) {
		return addNewScheduleUseCase.handle(rawScheduleInput);
	}
}
