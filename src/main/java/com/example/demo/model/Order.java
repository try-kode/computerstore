package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Order {

    private Long orderId;
    private Long userId;
    private Long customerId;
    private Double total;
    private String status;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;
}
