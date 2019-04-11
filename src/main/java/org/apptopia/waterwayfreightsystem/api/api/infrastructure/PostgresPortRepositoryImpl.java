package org.apptopia.waterwayfreightsystem.api.api.infrastructure;

import org.apptopia.waterwayfreightsystem.api.api.port.model.PortRepository;
import org.apptopia.waterwayfreightsystem.api.api.port.model.Port;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@Qualifier("PostgresPortRepository")
public interface PostgresPortRepositoryImpl extends JpaRepository<Port, Integer>,
	PortRepository, JpaSpecificationExecutor{

}
