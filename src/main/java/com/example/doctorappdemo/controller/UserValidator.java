package com.example.doctorappdemo.controller;

import com.example.doctorappdemo.entity.User;
import com.example.doctorappdemo.service.UserService;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {


    UserService userService;



    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email","NotEmpty");
        if (user.getEmail().length() < 8 || user.getEmail().length() > 16){
            errors.rejectValue("email","Email must be between 6 and 16 symbols");
        }

    }
}
