package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String uuid;
    private String orderNumber;
    private Long customerId;
    private Double total;
    private String status;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;
}
