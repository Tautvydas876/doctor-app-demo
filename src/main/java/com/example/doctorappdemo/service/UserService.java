package com.example.doctorappdemo.service;

import com.example.doctorappdemo.entity.User;


public interface UserService {

    User findUserByEmail(String email);

}
