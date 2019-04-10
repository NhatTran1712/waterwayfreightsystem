package org.apptopia.waterwayfreightsystem.api.api.core.model;

import java.util.List;

public interface TravelProblemRepository {
	
	TravelProblem save(TravelProblem travelProblem);
	List<TravelProblem> findAll();
}
