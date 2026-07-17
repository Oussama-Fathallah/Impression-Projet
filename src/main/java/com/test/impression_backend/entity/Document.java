package com.test.impression_backend.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
public class Document {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String fileName;


private String filePath;


private Integer pages;


    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


}