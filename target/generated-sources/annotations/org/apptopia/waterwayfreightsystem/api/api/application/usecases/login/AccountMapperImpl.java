package org.apptopia.waterwayfreightsystem.api.api.application.usecases.login;

import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-08T16:20:38+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class AccountMapperImpl implements AccountMapper {

    @Override
    public LoginOutput fromAccount(Account account) {
        if ( account == null ) {
            return null;
        }

        LoginOutput loginOutput = new LoginOutput();

        loginOutput.setUsername( account.getUsername() );
        loginOutput.setAccountType( account.getAccountType() );

        return loginOutput;
    }
}
