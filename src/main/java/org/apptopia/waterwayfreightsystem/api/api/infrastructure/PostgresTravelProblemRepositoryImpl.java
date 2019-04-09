package org.apptopia.waterwayfreightsystem.api.api.infrastructure;

import org.apptopia.waterwayfreightsystem.api.api.core.model.TravelProblemRepository;
import org.apptopia.waterwayfreightsystem.api.api.core.model.TravelProblem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@Qualifier("PostgresTravelProblemRepositoryImpl")
public interface PostgresTravelProblemRepositoryImpl extends 
	JpaRepository<TravelProblem, Integer>, TravelProblemRepository, JpaSpecificationExecutor {

}
