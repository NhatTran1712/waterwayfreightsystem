package org.apptopia.waterwayfreightsystem.api.api.application.usecases.orders;

import java.util.List;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.UseCaseOutput;
import org.apptopia.waterwayfreightsystem.api.api.core.model.Cargo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class RawOrdersOutput implements UseCaseOutput {
	private Integer idOrder;
	private Integer shipTransport;
	private List<Cargo> cargos;
	private Integer whoReceive;
	private Integer orderExpense;
}
