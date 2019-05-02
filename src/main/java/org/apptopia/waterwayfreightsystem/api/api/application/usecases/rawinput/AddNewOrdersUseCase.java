package org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput;

import org.apptopia.waterwayfreightsystem.api.api.application.OrdersService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddNewOrdersUseCase implements UseCase<RawOrdersInput,RawOrdersOutput> {
	@Autowired OrdersService ordersService;
	
	@Override
	public RawOrdersOutput handle(RawOrdersInput rawOrdersInput) {
		return ordersService.newOrders(rawOrdersInput);
	}
	
}
