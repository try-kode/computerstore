package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;
    private String uuid;
    private String brandName;
    private String description;
    private String status;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;

    public Brand() {
        this.status = "1";
        this.publisher = "s.admin";
        this.publishedDate = new Date();
        this.modifiedDate = new Date();
    }
}
