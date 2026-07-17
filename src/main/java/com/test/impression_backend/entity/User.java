package com.test.impression_backend.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name = "users")
public class User {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String email;


private String password;


}