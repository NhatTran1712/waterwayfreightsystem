package org.apptopia.waterwayfreightsystem.api.api.infrastructure;

import org.apptopia.waterwayfreightsystem.api.api.core.model.Cargo;
import org.apptopia.waterwayfreightsystem.api.api.core.model.CargoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@Qualifier("PostgresCargoRepository")
public interface PostgresCargoRepositoryImpl extends JpaRepository<Cargo, Integer>, 
	CargoRepository, JpaSpecificationExecutor {

}
