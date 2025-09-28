package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface IUserService {
    User createUser(User user);
    List<User> getAllUsers();
    User findUserById(Long id);
    User deleteUserById(Long id);
}
