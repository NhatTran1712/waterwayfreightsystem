package org.apptopia.waterwayfreightsystem.api.api.applications.usecases;

public interface UseCase<Inp extends UseCaseInput, Out extends UseCaseOutput> {
	Out handle(Inp input);
}
