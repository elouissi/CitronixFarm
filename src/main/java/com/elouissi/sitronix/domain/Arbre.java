package com.elouissi.sitronix.domain;

import com.elouissi.sitronix.utils.ProductiviteUtil;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
public class Arbre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate date_plantation;

    public Arbre(Integer id, LocalDate date_plantation, Champ champ, List<DetailRecolte> detailRecoltes) {
        this.id = id;
        this.date_plantation = date_plantation;
        this.champ = champ;
        this.detailRecoltes = detailRecoltes;
    }

    public Integer getAge() {
        if (this.date_plantation == null) {
            throw new IllegalStateException("La date de plantation n'est pas définie.");
        }
        Period age = Period.between(this.date_plantation, LocalDate.now());
        return age.getYears();
    }
    public Float calculerProductivite() {
        Integer age = this.getAge();

        if (age < 3) {
            return 2.5f;
        } else if (age <= 10) {
            return 12.0f;
        } else {
            return 20.0f;
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate_plantation() {
        return date_plantation;
    }

    public void setDate_plantation(LocalDate date_plantation) {
        this.date_plantation = date_plantation;
    }

    public Champ getChamp() {
        return champ;
    }

    public void setChamp(Champ champ) {
        this.champ = champ;
    }

    public List<DetailRecolte> getDetailRecoltes() {
        return detailRecoltes;
    }

    public void setDetailRecoltes(List<DetailRecolte> detailRecoltes) {
        this.detailRecoltes = detailRecoltes;
    }

    public Arbre() {
    }

    @ManyToOne
    private Champ champ;
    @OneToMany
    private List<DetailRecolte> detailRecoltes;
}
