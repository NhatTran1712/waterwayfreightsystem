package org.apptopia.waterwayfreightsystem.api.api.application.usecases.account;

import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.authentication.Account;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-08T16:20:38+0700",
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
        account.setFullname( rawAccountInput.getFullname() );
        account.setAddress( rawAccountInput.getAddress() );
        account.setPhoneNumber( rawAccountInput.getPhoneNumber() );
        account.setIdCard( rawAccountInput.getIdCard() );

        return account;
    }

    @Override
    public RawAccountOutput fromAccount(Account accout) {
        if ( accout == null ) {
            return null;
        }

        RawAccountOutput rawAccountOutput = new RawAccountOutput();

        rawAccountOutput.setUsername( accout.getUsername() );
        rawAccountOutput.setAccountType( accout.getAccountType() );
        rawAccountOutput.setFullname( accout.getFullname() );
        rawAccountOutput.setAddress( accout.getAddress() );
        rawAccountOutput.setPhoneNumber( accout.getPhoneNumber() );
        rawAccountOutput.setIdCard( accout.getIdCard() );

        return rawAccountOutput;
    }
}
