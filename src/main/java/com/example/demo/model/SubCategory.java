package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tblSubCategory")
@Data
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subCategoryId;
    private String uuid;
    private String subCategoryName;
    private String description;
    private Long categoryId;
    private String status;
    private String publisher;
    private Date publishedDate;
    private Date modifiedDate;

    public SubCategory() {
        this.status = "1";
        this.publisher = "s.admin";
        this.publishedDate = new Date();
        this.modifiedDate = new Date();
    }
}
