package com.example.doctorappdemo.service;


import com.example.doctorappdemo.entity.User;

public interface UserService {
    void save(User user);
    User findByEmail(String email);

}
