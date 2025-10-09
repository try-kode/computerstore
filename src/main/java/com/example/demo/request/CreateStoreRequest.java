package com.example.demo.request;

import lombok.Data;

@Data
public class CreateStoreRequest {
    private String storeName;
    private String description;
    private String address;
}
