package com.elouissi.sitronix.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ferme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nom;
    private Float superficie;
    private LocalDate date_creation;
    private String localisation;
    @OneToMany(mappedBy = "ferme", cascade = CascadeType.ALL)
    private List<Champ> champs;

}
