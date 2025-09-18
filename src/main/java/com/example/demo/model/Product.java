package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tblProduct")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String uuid;
    private String productCode;
    private String productName;
    private String description;
    private Double price;
    private Double discount;
    private String image;
    private String status;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;

    public Product() {
        this.status = "1";
        this.publisher = "s.admin";
        this.publishedDate = new Date();
        this.modifiedDate = new Date();
    }
}
