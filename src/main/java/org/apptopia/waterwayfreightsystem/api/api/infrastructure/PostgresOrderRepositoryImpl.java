package org.apptopia.waterwayfreightsystem.api.api.infrastructure;

import org.apptopia.waterwayfreightsystem.api.api.core.model.OrdersRepository;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Orders;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@Qualifier("PostgresOrderRepositoryImpl")
public interface PostgresOrderRepositoryImpl extends JpaRepository<Orders, Integer>,
	OrdersRepository, JpaSpecificationExecutor{

}
