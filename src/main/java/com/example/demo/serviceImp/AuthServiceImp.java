package com.example.demo.serviceImp;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp implements IAuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User login(String username, String password) {

        User user = userRepository.findByUsername(username.toLowerCase());
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())){
                return user;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public User register(User user) {
        return null;
    }
}
