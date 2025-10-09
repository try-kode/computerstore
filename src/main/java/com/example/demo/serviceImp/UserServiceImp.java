package com.example.demo.serviceImp;

import com.example.demo.model.Store;
import com.example.demo.model.User;
import com.example.demo.repository.StoreRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.UserStoreRepository;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        user.setUuid(UUID.randomUUID().toString());
        user.setUsername(user.getUsername().toLowerCase());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setUserToken("null");
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public User deleteUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
        userRepository.deleteById(id);
        return user;
    }

    @Override
    public User changePassword(Long userId, String currentPassword, String newPassword) {
        User curr = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("userId: "+userId+" not found"));
        if(passwordEncoder.matches(currentPassword, curr.getPassword())) {
            curr.setPassword(passwordEncoder.encode(newPassword));
            curr.setModifiedDate(new Date());
            return userRepository.save(curr);
        }
        else {
            return null;
        }
    }
}
