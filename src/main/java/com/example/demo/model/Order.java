package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tbl_order")
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
