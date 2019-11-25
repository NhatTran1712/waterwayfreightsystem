package org.apptopia.waterwayfreightsystem.api.api.application.usecases.account;

import javax.annotation.Generated;
import org.apptopia.waterwayfreightsystem.api.api.authentication.account.Account;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-11-26T02:38:55+0700",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_202 (Oracle Corporation)"
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
        account.setPhoneNum( rawAccountInput.getPhoneNum() );
        account.setIdCard( rawAccountInput.getIdCard() );

        return account;
    }

    @Override
    public RawAccountOutput fromAccount(Account account) {
        if ( account == null ) {
            return null;
        }

        RawAccountOutput rawAccountOutput = new RawAccountOutput();

        rawAccountOutput.setUsername( account.getUsername() );
        rawAccountOutput.setFullname( account.getFullname() );
        rawAccountOutput.setAddress( account.getAddress() );
        rawAccountOutput.setPhoneNum( account.getPhoneNum() );
        rawAccountOutput.setIdCard( account.getIdCard() );

        return rawAccountOutput;
    }
}
