package org.apptopia.waterwayfreightsystem.api.api.application;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersOutput;

public interface OrdersService {
	
	RawOrdersOutput newOrders(RawOrdersInput rawOrdersInput);
}
