package com.example.demo.core_api;

import com.example.demo.model.User;
import com.example.demo.request.UserRequest;
import com.example.demo.serviceImp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/")
    public ResponseEntity<Object> fetchAllUsers(){
        List<User> userList = userServiceImp.getAllUsers();
        return ApiResponseStructure.singleResponse("Success", userList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        User user = userServiceImp.findUserById(id);
        userServiceImp.deleteUserById(id);
        return ApiResponseStructure.singleResponse("Deleted", user, HttpStatus.OK);
    }
}
