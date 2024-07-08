package com.example.EtapStage.Entity;

import jakarta.persistence.*;

import java.io.Serializable;

public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TypeRole typeRole;

}
