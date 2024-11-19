package com.elouissi.sitronix.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Champ {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Float superficie;
    @ManyToOne
    @JoinColumn(name = "ferme_id")
    private Ferme ferme;

    @OneToMany
    private List<Arbre> arbres;
}
