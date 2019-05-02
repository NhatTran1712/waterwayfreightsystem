package org.apptopia.waterwayfreightsystem.api.api.application;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Orders;
import org.apptopia.waterwayfreightsystem.api.api.core.model.OrdersRepository;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {
	private OrdersRepository ordersRepository;
	
	@Autowired
	public void setOrdersRepository(@Qualifier("PostgresOrdersRepository") OrdersRepository
		ordersRepository) {
		
		this.ordersRepository = ordersRepository;
	}
	
	@Override
	public RawOrdersOutput newOrders(RawOrdersInput rawOrdersInput) {
		Orders order = RawOrdersMapper.INSTANCE.fromRawInput(rawOrdersInput);
		Ship ship = RawOrdersMapper.INSTANCE.toShip(rawOrdersInput.getShipTransport());
		Account account = RawOrdersMapper.INSTANCE.toAccount(rawOrdersInput.getWhoReceive());
		
		order.setShipTransport(ship);
		order.setWhoReceive(account);
		ordersRepository.save(order);
		return RawOrdersMapper.INSTANCE.fromOrders(order);
	}

}
