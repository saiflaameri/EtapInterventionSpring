package com.example.EtapStage.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "GroupeProjet")

public class GroupeProjet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom ;

    public GroupeProjet() {

    }
}
