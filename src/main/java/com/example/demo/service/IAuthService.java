package com.example.demo.service;

import com.example.demo.model.User;

public interface IAuthService {

    User login(String username, String password);
    User register(User user);

}
