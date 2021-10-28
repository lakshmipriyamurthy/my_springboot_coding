package com.pack.SpringBootJPAIntegration.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.pack.SpringBootJPAIntegration.model.User;
import com.pack.SpringBootJPAIntegration.service.UserService;


@Component
public class UserValidator implements Validator {
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }
  @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

 

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (user.getUsername().length() < 4 || user.getUsername().length() > 32) {
           errors.rejectValue("username", "Size.userForm.username");
        	// errors.rejectValue("username", "Username should be more than 4 and less than 32 Character. ");
        }
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
           // errors.rejectValue("username", "Username already exists");
        }

 

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 4 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
           // errors.rejectValue("password", "Password should be more than 4 and less than 32 Character. ");

        }

 

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
            //errors.rejectValue("password", "Password and Confirm Password doesnt match");

        }
    }
}
 