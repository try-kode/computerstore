package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tblUserStore")
@Data
public class UserStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userStoreId;
    private String uuid;
    private Long userId;
    private Long storeId;
}
