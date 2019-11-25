package org.apptopia.waterwayfreightsystem.api.api.authentication.account;

import org.apptopia.waterwayfreightsystem.api.api.application.usecases.account.RawAccountInput;
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
        RawAccountInput rawAccountInput = (RawAccountInput) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if(rawAccountInput.getUsername().length()<3 || rawAccountInput.getUsername().length()>25) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if(accountRepository.findByUsername(rawAccountInput.getUsername()).isPresent()) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if(rawAccountInput.getPassword().length()<8 || rawAccountInput.getPassword().length()>32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if(!rawAccountInput.getPassConfirm().equals(rawAccountInput.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }
        if(rawAccountInput.getFullname().length()<2 || rawAccountInput.getFullname().length()>25) {
            errors.rejectValue("fullname", "Size.userForm.fullname");
        }
        if((rawAccountInput.getPhoneNum()!=null)&&(rawAccountInput.getPhoneNum().length()>10)){
            errors.rejectValue("phoneNumber", "phoneNumber.length", "Nhap so dien thoai khong qua 10 so");
        }
        if(!rawAccountInput.getIdCard().isEmpty()) {
        	System.out.println("idCard " + rawAccountInput.getIdCard());
	        if((rawAccountInput.getIdCard().length()<9)||(rawAccountInput.getIdCard().length()>12)){
	            errors.rejectValue("idCard", "idCard.length", "Nhap CMND tu 9 den 12 so");
	        }
        }
    }
}
