package org.apptopia.waterwayfreightsystem.api.api;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.AccountService;
import org.apptopia.waterwayfreightsystem.api.api.application.ScheduleService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.delete.DeleteScheduleUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput.AddNewScheduleUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate.UpdateScheduleUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule.RawScheduleOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@CrossOrigin
@RequestMapping("/schedule")
public class ScheduleController {
	private ScheduleService scheduleService;
	private AccountService accountService;
	private AddNewScheduleUseCase addNewScheduleUseCase;
	private UpdateScheduleUseCase updateScheduleUseCase;
	private DeleteScheduleUseCase deleteScheduleUseCase;
	
	@Autowired
	public void setService(ScheduleService scheduleService, AccountService accountService) {
		this.scheduleService = scheduleService;
		this.accountService = accountService;
	}
	
	@Autowired
	public void setScheduleUseCase(AddNewScheduleUseCase addNewScheduleUseCase,
		UpdateScheduleUseCase updateScheduleUseCase, DeleteScheduleUseCase deleteScheduleUseCase) {
		this.addNewScheduleUseCase = addNewScheduleUseCase;
		this.updateScheduleUseCase = updateScheduleUseCase;
		this.deleteScheduleUseCase = deleteScheduleUseCase;
	}
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String getAllSchedules(Model model){
		model.addAttribute("schedules", scheduleService.findAllSchedules());
		model.addAttribute("accounts", accountService.findAllAccount());
		return "show-schedules-manager";
	}
	
	@RequestMapping(value = {"/search"}, method = RequestMethod.GET)
	public String searchScheduleByNameSchedule(@RequestParam("nameSchedule") String nameSchedule,
		Model model){
		if(nameSchedule.equals("")) {
			return "redirect:/schedule";
		}
		model.addAttribute("schedules", scheduleService.findScheduleByNameSchedule(nameSchedule));
		model.addAttribute("accounts", accountService.findAllAccount());
		return "show-schedules-manager";
	}
	
	@RequestMapping(value = {"/update"}, method = RequestMethod.GET)
//	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public String updateSchedule(@RequestParam("id") Long idSchedule, Model model) {
		model.addAttribute("schedule", scheduleService.findScheduleByIdSchedule(idSchedule));
		model.addAttribute("accounts", accountService.findAccountByAccountType("staff"));
		return "update-schedule";
	}
	
	@RequestMapping(value = {"/update"}, method = RequestMethod.POST)
//	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public String updateSchedule(RawScheduleInput rawScheduleInput, Model model) {
		updateScheduleUseCase.handle(rawScheduleInput);
		return "redirect:/home-manager";
	}
	
	@RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
	public String deleteSchedule(@RequestParam("id") Long idSchedule, RedirectAttributes redirect){
		deleteScheduleUseCase.handle(idSchedule);
		redirect.addFlashAttribute("success", "Xoa tuyen duong thanh cong!");
		return "redirect:/schedule";
	}
	
	@RequestMapping(value = {"/add/","/add"}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public RawScheduleOutput addNewSchedule(@RequestBody RawScheduleInput rawScheduleInput) {
		return addNewScheduleUseCase.handle(rawScheduleInput);
	}
}
