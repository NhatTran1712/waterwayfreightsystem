package org.apptopia.waterwayfreightsystem.api.api;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersOutput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.rawinput.AddNewOrdersUseCase;
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
@RequestMapping("/orders")
public class OrdersController {
	private AddNewOrdersUseCase addNewOrdersUseCase;
	
	@Autowired
	public void setOrdersUseCase(AddNewOrdersUseCase addNewOrdersUseCase) {
		
		this.addNewOrdersUseCase = addNewOrdersUseCase;
	}
	
	@RequestMapping(value = {"/add/","/add"}, produces = "application/json",
		consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	@ResponseBody
	public RawOrdersOutput addNewOrders(@RequestBody RawOrdersInput rawOrdersInput) {
		return addNewOrdersUseCase.handle(rawOrdersInput);
	}
}
