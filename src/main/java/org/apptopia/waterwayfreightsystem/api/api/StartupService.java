package org.apptopia.waterwayfreightsystem.api.api;

import org.apptopia.waterwayfreightsystem.api.api.application.CargoService;
import org.apptopia.waterwayfreightsystem.api.api.application.OrdersService;
import org.apptopia.waterwayfreightsystem.api.api.application.PortService;
import org.apptopia.waterwayfreightsystem.api.api.application.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupService {
	private CargoService cargoService;
	private PortService portService;
	private ScheduleService scheduleService;
	private OrdersService ordersService;
	
	@Autowired
	public void setStartupService(CargoService cargoService, PortService portService, OrdersService
		ordersService, ScheduleService scheduleService) {
		this.cargoService = cargoService;
		this.portService = portService;
		this.scheduleService = scheduleService;
		this.ordersService = ordersService;
	}
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		cargoService.initDataCargo();
		portService.initDataPort();
		scheduleService.initDataSchedule();
//		ordersService.initDataOrders();
		
	}
}
