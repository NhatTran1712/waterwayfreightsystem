package org.apptopia.waterwayfreightsystem.api.api.infrastructure;

import org.apptopia.waterwayfreightsystem.api.api.core.model.OrderRepository;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Order;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@Qualifier("PostgresOrderRepositoryImpl")
public interface PostgresOrderRepositoryImpl extends JpaRepository<Order, Integer>,
	OrderRepository, JpaSpecificationExecutor{

}
