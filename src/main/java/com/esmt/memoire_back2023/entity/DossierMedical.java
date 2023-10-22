package com.esmt.memoire_back2023.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "DossierMedical")
public class DossierMedical {

    @Id
    @Column(name = "id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdDossier;

    @Column(name = "dateCreation", length = 255)
    private String dateCreation;

    @Column(name = "description", length = 255)
    private String description;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;


    public DossierMedical() {
    }

    public DossierMedical(Long idDossier, String dateCreation, String description) {
        IdDossier = idDossier;
        this.dateCreation = dateCreation;
        this.description = description;
    }

    public DossierMedical(Long idDossier, String dateCreation, String description, Patient patient) {
        IdDossier = idDossier;
        this.dateCreation = dateCreation;
        this.description = description;
        this.patient = patient;
    }

    public Long getIdDossier() {
        return IdDossier;
    }

    public void setIdDossier(Long idDossier) {
        IdDossier = idDossier;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
