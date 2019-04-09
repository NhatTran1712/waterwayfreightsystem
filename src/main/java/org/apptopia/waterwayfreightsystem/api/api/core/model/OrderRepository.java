package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.util.List;

public interface OrderRepository {
	
	Order save(Order order);
	List<Order> findAll();
}
