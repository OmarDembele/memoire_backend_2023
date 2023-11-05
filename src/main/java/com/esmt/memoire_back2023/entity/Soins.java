package com.esmt.memoire_back2023.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Soins")
public class Soins {

    @Id
    @Column(name = "id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    private String traitement;

    private Long dossier_medical_id;

    private Long personnel_id;

    public Soins() {
    }

    public Soins(Long id, String date, String traitement, Long dossier_medical_id, Long personnel_id) {
        this.id = id;
        this.date = date;
        this.traitement = traitement;
        this.dossier_medical_id = dossier_medical_id;
        this.personnel_id = personnel_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTraitement() {
        return traitement;
    }

    public void setTraitement(String traitement) {
        this.traitement = traitement;
    }

    public Long getDossier_medical_id() {
        return dossier_medical_id;
    }

    public void setDossier_medical_id(Long dossier_medical_id) {
        this.dossier_medical_id = dossier_medical_id;
    }

    public Long getPersonnel_id() {
        return personnel_id;
    }

    public void setPersonnel_id(Long personnel_id) {
        this.personnel_id = personnel_id;
    }
}
