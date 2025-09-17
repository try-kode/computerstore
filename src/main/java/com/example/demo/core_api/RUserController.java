package com.example.demo.core_api;

import com.example.demo.model.User;
import com.example.demo.request.UserRequest;
import com.example.demo.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class RUserController {

    @Autowired
    UserServiceImp userServiceImp;

    @PostMapping("/create")
    public ResponseEntity<Object> create(@RequestBody UserRequest userRequest){
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        userServiceImp.createUser(user);
        return ApiResponseStructure.singleResponse("Created", user, HttpStatus.CREATED);

    }
}
