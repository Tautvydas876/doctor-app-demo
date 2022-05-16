package com.example.doctorappdemo.controller;

import com.example.doctorappdemo.entity.User;
import com.example.doctorappdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
        System.out.println(user);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","NotEmpty");
        if (user.getEmail().length() < 8 || user.getEmail().length() > 16){
            errors.rejectValue("email","Size.userForm.email");
        }
        if(userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email","Duplicate.userForm.email");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NotEmpty");
        if (user.getPass().length() < 8 || user.getPass().length() > 16 ){
            errors.rejectValue("password","Size.userForm.password");
        }


    }
}
