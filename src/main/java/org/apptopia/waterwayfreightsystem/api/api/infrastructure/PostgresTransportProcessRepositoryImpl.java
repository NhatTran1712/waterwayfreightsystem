package org.apptopia.waterwayfreightsystem.api.api.infrastructure;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TransportProcess;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TransportProcessRepository;

@Service
@Qualifier("PostgresTransportProcessRepository")
public interface PostgresTransportProcessRepositoryImpl extends 
	JpaRepository<TransportProcess, Integer>, TransportProcessRepository,
	JpaSpecificationExecutor {

}
