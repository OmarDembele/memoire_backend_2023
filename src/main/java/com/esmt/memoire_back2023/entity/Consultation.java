package com.esmt.memoire_back2023.entity;

import jakarta.persistence.*;

@Entity
public class Consultation {
    @Id
    @Column(name = "idConsultation", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsultation;

    private Long dossierMedical_id;

    private Long medecin_traitant;

    private Long medecin_consultant;

    private Long medecin_chirurgien;

    private String poids;

    private String taille;

    private String nameurgence;

    private String adresse;

    private String telephone;

    private String antecedent;

    private String ancientraitement;

    private String dateconsultation;

    private String diagnostic;
    private String description;



    public Consultation() {
    }

    public Consultation(Long idConsultation, String diagnostic, String description) {
        this.idConsultation = idConsultation;
        this.diagnostic = diagnostic;
        this.description = description;
    }

    public Consultation(Long idConsultation, Long medecinTraitant, Long medecinConsultant, Long medecinChirurgien, String diagnostic, String description) {
        this.idConsultation = idConsultation;
        this.medecin_traitant = medecinTraitant;
        this.medecin_consultant = medecinConsultant;
        this.medecin_chirurgien = medecinChirurgien;
        this.diagnostic = diagnostic;
        this.description = description;
    }


    public Consultation(Long idConsultation, Long dossierMedical_id, Long medecinTraitant, Long medecinConsultant, Long medecinChirurgien, String poids, String taille, String nameurgence, String adresse, String telephone, String antecedent, String ancientraitement, String dateconsultation, String diagnostic, String description) {
        this.idConsultation = idConsultation;
        this.dossierMedical_id = dossierMedical_id;
        this.medecin_traitant = medecinTraitant;
        this.medecin_consultant = medecinConsultant;
        this.medecin_chirurgien = medecinChirurgien;
        this.poids = poids;
        this.taille = taille;
        this.nameurgence = nameurgence;
        this.adresse = adresse;
        this.telephone = telephone;
        this.antecedent = antecedent;
        this.ancientraitement = ancientraitement;
        this.dateconsultation = dateconsultation;
        this.diagnostic = diagnostic;
        this.description = description;
    }

    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }

    public Long getDossierMedical_id() {
        return dossierMedical_id;
    }

    public void setDossierMedical_id(Long dossierMedical_id) {
        this.dossierMedical_id = dossierMedical_id;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getMedecinTraitant() {
        return medecin_traitant;
    }

    public void setMedecinTraitant(Long medecinTraitant) {
        this.medecin_traitant = medecinTraitant;
    }

    public Long getMedecinConsultant() {
        return medecin_consultant;
    }

    public void setMedecinConsultant(Long medecinConsultant) {
        this.medecin_consultant = medecinConsultant;
    }

    public Long getMedecinChirurgien() {
        return medecin_chirurgien;
    }

    public void setMedecinChirurgien(Long medecinChirurgien) {
        this.medecin_chirurgien = medecinChirurgien;
    }

    public String getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(String antecedent) {
        this.antecedent = antecedent;
    }

    public String getAncientraitement() {
        return ancientraitement;
    }

    public void setAncientraitement(String ancientraitement) {
        this.ancientraitement = ancientraitement;
    }

    public String getDateconsultation() {
        return dateconsultation;
    }

    public void setDateconsultation(String dateconsultation) {
        this.dateconsultation = dateconsultation;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getNameurgence() {
        return nameurgence;
    }

    public void setNameurgence(String nameurgence) {
        this.nameurgence = nameurgence;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



}

