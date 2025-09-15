package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String uuid;
    private String categoryName;
    private String description;
    private String status;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;

    public Category() {
        this.status = "1";
        this.publisher = "s.admin";
        this.publishedDate = new Date();
        this.modifiedDate = new Date();
    }
}
