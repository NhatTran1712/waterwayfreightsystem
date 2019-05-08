package org.apptopia.waterwayfreightsystem.api.api.application;

public interface SecurityService {
	String findLoggedInUsername();
    void autoLogin(String username, String password);
}
