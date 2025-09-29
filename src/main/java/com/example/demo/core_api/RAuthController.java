package com.example.demo.core_api;

import com.example.demo.model.User;
import com.example.demo.request.LoginRequest;
import com.example.demo.serviceImp.AuthServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class RAuthController {

    @Autowired
    AuthServiceImp authServiceImp;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody LoginRequest loginRequest){
        User user = authServiceImp.login(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null){
            return ApiResponseStructure.singleResponse("Authenticated", user, HttpStatus.OK);
        } else {
            return ApiResponseStructure.singleResponse("Authenticate failed", null, HttpStatus.OK);
        }

    }
}
