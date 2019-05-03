package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository {
	
	Orders save(Orders order);
	List<Orders> findAll();
	Optional<Orders> findById(Integer idOrders);
}
