package org.apptopia.waterwayfreightsystem.api.api.application;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersInput;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersMapper;
import org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders.RawOrdersOutput;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;
import org.apptopia.waterwayfreightsystem.api.api.authentication.AccountRepository;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Cargo;
import org.apptopia.waterwayfreightsystem.api.api.core.model.CargoRepository;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Orders;
import org.apptopia.waterwayfreightsystem.api.api.core.model.OrdersRepository;
import org.apptopia.waterwayfreightsystem.api.api.ship.model.Ship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {
	private OrdersRepository ordersRepository;
	private AccountRepository accountRepository;
	private CargoRepository cargoRepository;
	
	@Autowired
	public void setRepository(@Qualifier("PostgresOrdersRepository") OrdersRepository
		ordersRepository, AccountRepository accountRepository,
		@Qualifier("PostgresCargoRepository") CargoRepository cargoRepository) {
		
		this.ordersRepository = ordersRepository;
		this.accountRepository = accountRepository;
		this.cargoRepository = cargoRepository;
	}
	
	@Override
	public List<RawOrdersOutput> initDataOrders() {
		List<RawOrdersOutput> rawOrdersOutput = new ArrayList<>();
		Optional<Account> existingOne = accountRepository.findByUsername("user");
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("User not existed");
		}
		List<Cargo> cargos = cargoRepository.findByOwner(existingOne.get());
		
		
		return null;
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

	@Override
	public RawOrdersOutput updateOrders(RawOrdersInput rawOrdersInput) {
		Optional<Orders> existingOne = ordersRepository.findById(rawOrdersInput.getIdOrder());
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Order not existed");
		}
		Orders order = RawOrdersMapper.INSTANCE.fromRawInput(rawOrdersInput);
		
		ordersRepository.save(order);
		return RawOrdersMapper.INSTANCE.fromOrders(order);
	}

	@Override
	public List<RawOrdersOutput> getAllOrders() {
		List<Orders> orders = ordersRepository.findAll();
		List<RawOrdersOutput> rawOrdersOutputs = new ArrayList<>();
		
		for(Orders order : orders) {
			rawOrdersOutputs.add(RawOrdersMapper.INSTANCE.fromOrders(order));
		}
		return rawOrdersOutputs;
	}

	@Override
	public List<RawOrdersOutput> getOrdersOfCustomer(Long idUser) {
		Optional<Account> existingOne = accountRepository.findOne(idUser);
		List<RawOrdersOutput> rawOrdersOutputs = new ArrayList<>();
		
		if(!existingOne.isPresent()) {
			throw new IllegalArgumentException("Account not existed");
		}
		Account account = existingOne.get();
		List<Orders> orders = findOrdersByWhoOwner(account);
		
		for(Orders order : orders) {
			rawOrdersOutputs.add(RawOrdersMapper.INSTANCE.fromOrders(order));
		}
		return rawOrdersOutputs;
	}

	@Override
	public List<Orders> findOrdersByWhoOwner(Account account) {
		List<Orders> orders = ordersRepository.findAll();
		List<Orders> customerOrders = new ArrayList<>();
		
		for(Orders order : orders) {
			ListIterator<Cargo> itr = order.getCargos().listIterator();
			int isBreak = 0;
			while(itr.hasNext() && isBreak == 0) {
				if(itr.next().getOwner() == account) {
					customerOrders.add(order);
				}
				isBreak = 1;
			}
		}
		return customerOrders;
	}
}
