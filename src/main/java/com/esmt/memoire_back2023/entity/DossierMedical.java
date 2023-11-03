package com.esmt.memoire_back2023.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "DossierMedical")
public class DossierMedical {

    @Id
    @Column(name = "idDossier", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdDossier;

    @Column(name = "numero_dossier", length = 255)
    private String numero_dossier;

    @Column(name = "dateCreation", length = 255)
    private String dateCreation;

    @Column(name = "description", length = 255)
    private String description;

    @OneToMany(mappedBy = "dossierMedical_id", cascade = CascadeType.ALL)
    private List<Hospitalisation> hospitalisations;

    public DossierMedical() {
    }

    public DossierMedical(Long idDossier, String dateCreation, String description) {
        IdDossier = idDossier;
        this.dateCreation = dateCreation;
        this.description = description;
    }

    public DossierMedical(Long idDossier, String numero_dossier, String dateCreation, String description, List<Hospitalisation> hospitalisations) {
        IdDossier = idDossier;
        this.numero_dossier = numero_dossier;
        this.dateCreation = dateCreation;
        this.description = description;
        this.hospitalisations = hospitalisations;
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

    public String getNumero_dossier() {
        return numero_dossier;
    }

    public void setNumero_dossier(String numero_dossier) {
        this.numero_dossier = numero_dossier;
    }

    public List<Hospitalisation> getHospitalisations() {
        return hospitalisations;
    }

    public void setHospitalisations(List<Hospitalisation> hospitalisations) {
        this.hospitalisations = hospitalisations;
    }
}
