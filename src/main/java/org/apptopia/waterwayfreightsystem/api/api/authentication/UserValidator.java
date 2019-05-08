package org.apptopia.waterwayfreightsystem.api.api.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
	@Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return Account.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Account account = (Account) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (account.getUsername().length() < 3 || account.getUsername().length() > 25) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (accountRepository.findByUsername(account.getUsername()).isPresent()) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (account.getPassword().length() < 8 || account.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if (!account.getPasswordConfirm().equals(account.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
    }
}
