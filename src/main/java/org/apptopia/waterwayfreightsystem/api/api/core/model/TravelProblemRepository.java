package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.util.List;
import java.util.Optional;

public interface TravelProblemRepository {
	
	TravelProblem save(TravelProblem travelProblem);
	List<TravelProblem> findAll();
	Optional<TravelProblem> findById(Integer idTravelProblem);
}
