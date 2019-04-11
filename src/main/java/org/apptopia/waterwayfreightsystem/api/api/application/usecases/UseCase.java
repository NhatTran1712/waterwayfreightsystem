package org.apptopia.waterwayfreightsystem.api.api.application.usecases;

public interface UseCase<Inp extends UseCaseInput, Out extends UseCaseOutput> {
	Out handle(Inp input);
}
