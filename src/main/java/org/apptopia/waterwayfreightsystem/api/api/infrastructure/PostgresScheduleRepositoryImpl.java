package org.apptopia.waterwayfreightsystem.api.api.infrastructure;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.core.model.Schedule;
import org.apptopia.waterwayfreightsystem.api.api.core.model.ScheduleRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Service;

@Service
@Qualifier("PostgresScheduleRepository")
public interface PostgresScheduleRepositoryImpl extends JpaRepository<Schedule, Integer>,
	ScheduleRepository, JpaSpecificationExecutor{
	
}
