package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Orders;

public interface OrdersService {
	
	RawOrdersOutput newOrders(RawOrdersInput rawOrdersInput);
	RawOrdersOutput updateOrders(RawOrdersInput rawOrdersInput);
	List<RawOrdersOutput> getAllOrders();
	List<RawOrdersOutput> getOrdersOfCustomer(Long idUser);
	List<Orders> findOrdersByWhoOwner(Account account);
}
