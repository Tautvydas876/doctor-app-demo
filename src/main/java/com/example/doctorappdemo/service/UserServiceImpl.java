package com.example.doctorappdemo.service;

import com.example.doctorappdemo.dao.UserRepository;
import com.example.doctorappdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserByEmail(String email) {
        User rezult = userRepository.findUserByEmail(email);
        User user = null;
        if (rezult != null){
            user = rezult;
        } else{
            throw new RuntimeException("Haven't found user: " + email);
        }
        return user;
    }

}
