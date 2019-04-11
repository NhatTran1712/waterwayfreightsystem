package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.util.List;

public interface OrdersRepository {
	
	Orders save(Orders order);
	List<Orders> findAll();
}
