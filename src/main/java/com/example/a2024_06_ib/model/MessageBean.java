package com.example.a2024_06_ib.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "message")
@Data
public class MessageBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message, pseudo;
}
