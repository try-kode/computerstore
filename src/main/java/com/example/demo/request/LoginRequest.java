package com.example.demo.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "The username field is required")
    private String username;
    @NotBlank(message = "The username field is required")
    private String password;
}
