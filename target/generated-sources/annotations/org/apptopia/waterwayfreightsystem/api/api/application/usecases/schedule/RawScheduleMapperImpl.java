package org.apptopia.waterwayfreightsystem.api.api.application.usecases.schedule;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Schedule;
import org.apptopia.waterwayfreightsystem.api.api.port.model.Port;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-10T04:19:20+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class RawScheduleMapperImpl implements RawScheduleMapper {

    @Override
    public Schedule fromRawInput(RawScheduleInput rawScheduleInput) {
        if ( rawScheduleInput == null ) {
            return null;
        }

        Schedule schedule = new Schedule();

        schedule.setIdSchedule( rawScheduleInput.getIdSchedule() );
        List<Port> list = rawScheduleInput.getVisitingPorts();
        if ( list != null ) {
            schedule.setVisitingPorts( new ArrayList<Port>( list ) );
        }
        schedule.setEstimateDistance( rawScheduleInput.getEstimateDistance() );
        schedule.setEstimateTime( rawScheduleInput.getEstimateTime() );
        schedule.setDateDepart( rawScheduleInput.getDateDepart() );
        schedule.setDateArrive( rawScheduleInput.getDateArrive() );
        schedule.setWhoManage( toAccount( rawScheduleInput.getWhoManage() ) );

        return schedule;
    }

    @Override
    public RawScheduleOutput fromSchedule(Schedule schedule) {
        if ( schedule == null ) {
            return null;
        }

        RawScheduleOutput rawScheduleOutput = new RawScheduleOutput();

        rawScheduleOutput.setIdSchedule( schedule.getIdSchedule() );
        List<Port> list = schedule.getVisitingPorts();
        if ( list != null ) {
            rawScheduleOutput.setVisitingPorts( new ArrayList<Port>( list ) );
        }
        rawScheduleOutput.setEstimateDistance( schedule.getEstimateDistance() );
        rawScheduleOutput.setEstimateTime( schedule.getEstimateTime() );
        rawScheduleOutput.setDateDepart( schedule.getDateDepart() );
        rawScheduleOutput.setDateArrive( schedule.getDateArrive() );
        if ( schedule.getWhoManage() != null ) {
            rawScheduleOutput.setWhoManage( fromAccount( schedule.getWhoManage() ).intValue() );
        }

        return rawScheduleOutput;
    }
}
