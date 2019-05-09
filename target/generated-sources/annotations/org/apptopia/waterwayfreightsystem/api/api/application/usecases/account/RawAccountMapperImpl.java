package org.apptopia.waterwayfreightsystem.api.api.application.usecases.account;

import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-10T04:19:20+0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_201 (Oracle Corporation)"
)
public class RawAccountMapperImpl implements RawAccountMapper {

    @Override
    public Account fromRawInput(RawAccountInput rawAccountInput) {
        if ( rawAccountInput == null ) {
            return null;
        }

        Account account = new Account();

        account.setIdUser( rawAccountInput.getIdUser() );
        account.setUsername( rawAccountInput.getUsername() );
        account.setPassword( rawAccountInput.getPassword() );
        account.setAccountType( rawAccountInput.getAccountType() );
        account.setFullname( rawAccountInput.getFullname() );
        account.setAddress( rawAccountInput.getAddress() );
        account.setPhoneNumber( rawAccountInput.getPhoneNumber() );
        account.setIdCard( rawAccountInput.getIdCard() );

        return account;
    }

    @Override
    public RawAccountOutput fromAccount(Account account) {
        if ( account == null ) {
            return null;
        }

        RawAccountOutput rawAccountOutput = new RawAccountOutput();

        rawAccountOutput.setIdUser( account.getIdUser() );
        rawAccountOutput.setUsername( account.getUsername() );
        rawAccountOutput.setPassword( account.getPassword() );
        rawAccountOutput.setPasswordConfirm( account.getPasswordConfirm() );
        rawAccountOutput.setAccountType( account.getAccountType() );
        rawAccountOutput.setFullname( account.getFullname() );
        rawAccountOutput.setAddress( account.getAddress() );
        rawAccountOutput.setPhoneNumber( account.getPhoneNumber() );
        rawAccountOutput.setIdCard( account.getIdCard() );

        return rawAccountOutput;
    }
}
