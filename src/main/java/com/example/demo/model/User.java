package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "tblUser")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String uuid;
    private String username;
    private String email;
    private String password;
    private String userToken;
    private String role;
    private String status;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;

    public User() {
        this.role = "USER";
        this.status = "1";
        this.publisher = "s.admin";
        this.publishedDate = new Date();
        this.modifiedDate = new Date();
    }
}
