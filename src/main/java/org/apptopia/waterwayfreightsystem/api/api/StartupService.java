package org.apptopia.waterwayfreightsystem.api.api;

import org.apptopia.waterwayfreightsystem.api.api.application.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupService {
	@Autowired CargoService cargoService;
	
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		cargoService.initDataCargo();
	}
}
