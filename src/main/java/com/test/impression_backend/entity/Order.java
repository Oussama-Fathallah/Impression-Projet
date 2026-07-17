package com.test.impression_backend.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name="orders")
public class Order {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String mode;


private Double price;


    @Transient
    private Long fileId;

@ManyToOne
private Document document;


@ManyToOne
private User user;


}