package org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Cargo;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Orders;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-11-06T02:12:15+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class RawOrdersMapperImpl implements RawOrdersMapper {

    @Override
    public Orders fromRawInput(RawOrdersInput rawOrdersInput) {
        if ( rawOrdersInput == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setIdOrder( rawOrdersInput.getIdOrder() );
        orders.setShipTransport( toShip( rawOrdersInput.getShipTransport() ) );
        List<Cargo> list = rawOrdersInput.getCargos();
        if ( list != null ) {
            orders.setCargos( new ArrayList<Cargo>( list ) );
        }
        orders.setWhoReceive( toAccount( rawOrdersInput.getWhoReceive() ) );
        orders.setOrderExpense( rawOrdersInput.getOrderExpense() );

        return orders;
    }

    @Override
    public RawOrdersOutput fromOrders(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        RawOrdersOutput rawOrdersOutput = new RawOrdersOutput();

        rawOrdersOutput.setIdOrder( orders.getIdOrder() );
        rawOrdersOutput.setShipTransport( fromShip( orders.getShipTransport() ) );
        List<Cargo> list = orders.getCargos();
        if ( list != null ) {
            rawOrdersOutput.setCargos( new ArrayList<Cargo>( list ) );
        }
        if ( orders.getWhoReceive() != null ) {
            rawOrdersOutput.setWhoReceive( fromAccount( orders.getWhoReceive() ).intValue() );
        }
        rawOrdersOutput.setOrderExpense( orders.getOrderExpense() );

        return rawOrdersOutput;
    }
}
