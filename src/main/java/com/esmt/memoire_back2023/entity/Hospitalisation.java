package com.esmt.memoire_back2023.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Hospitalisation")
public class Hospitalisation {

    @Id
    @Column(name = "idHospitalisation", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String datehospitalisation;

    private String lieu;

    private String type;

    private String datesortie;

    private String lit;

    private Long dossierMedical_id;

    public Hospitalisation() {
    }

    public Hospitalisation(Long id, String datehospitalisation, String lieu, String type, String datesortie, String lit, Long dossierMedical_id) {
        this.id = id;
        this.datehospitalisation = datehospitalisation;
        this.lieu = lieu;
        this.type = type;
        this.datesortie = datesortie;
        this.lit = lit;
        this.dossierMedical_id = dossierMedical_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDatehospitalisation() {
        return datehospitalisation;
    }

    public void setDatehospitalisation(String datehospitalisation) {
        this.datehospitalisation = datehospitalisation;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatesortie() {
        return datesortie;
    }

    public void setDatesortie(String datesortie) {
        this.datesortie = datesortie;
    }

    public String getLit() {
        return lit;
    }

    public void setLit(String lit) {
        this.lit = lit;
    }

    public Long getDossierMedical_id() {
        return dossierMedical_id;
    }

    public void setDossierMedical_id(Long dossierMedical_id) {
        this.dossierMedical_id = dossierMedical_id;
    }
}
