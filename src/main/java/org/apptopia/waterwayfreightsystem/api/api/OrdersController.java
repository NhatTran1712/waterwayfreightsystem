package org.apptopia.waterwayfreightsystem.api.api;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.OrdersService;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput.AddNewOrdersUseCase;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawupdate.UpdateOrdersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {
	private OrdersService ordersService;
	private AddNewOrdersUseCase addNewOrdersUseCase;
	private UpdateOrdersUseCase updateOrdersUseCase;
	
	@Autowired
	public void setOrdersService(OrdersService ordersService) {
		this.ordersService = ordersService;
	}
	
	@Autowired
	public void setOrdersUseCase(AddNewOrdersUseCase addNewOrdersUseCase, UpdateOrdersUseCase
		updateOrdersUseCase) {
		
		this.addNewOrdersUseCase = addNewOrdersUseCase;
		this.updateOrdersUseCase = updateOrdersUseCase;
	}
	
	@RequestMapping(value = {"/",""}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public List<RawOrdersOutput> getAllOrders(){
		return ordersService.getAllOrders();
	}
	
	@RequestMapping(value = {"/add/","/add"}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public RawOrdersOutput addNewOrders(@RequestBody RawOrdersInput rawOrdersInput) {
		return addNewOrdersUseCase.handle(rawOrdersInput);
	}
	
	@RequestMapping(value = {"/update/","/update"}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_MANAGER')")
	public RawOrdersOutput updateOrders(@RequestBody RawOrdersInput rawOrdersInput) {
		return updateOrdersUseCase.handle(rawOrdersInput);
	}
	
	@RequestMapping(value = {"/show-all/{id}/","/show-all/{id}"}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@PreAuthorize("hasRole('ROLE_USER' || 'ROLE_MANAGER')")
	public List<RawOrdersOutput> getOrdersOfCustomer(@PathVariable("id") Long idUser){
		return ordersService.getOrdersOfCustomer(idUser);
	}
}
