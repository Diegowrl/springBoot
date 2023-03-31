package com.santander.spring.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_broker")
public class BrokerId {
    @Id
    private Long id;
    private String name;
}
