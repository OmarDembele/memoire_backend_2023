package com.esmt.memoire_back2023.dto;

import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Personnels;
import jakarta.persistence.Column;

public class PatientDTO {

    private Long id;

    private String nom;

    private String prenom;

    private String sexe;

    private String dateNaissance;

    private String lieuNaissance;

    private String telephone;

    private String email;

    private String adresse;

    private String profession;

    private String groupe_sanguin;

    private Long dossierMedicalId;

    private DossierMedical dossierMedical;

    private Long personnel_id;

    public PatientDTO() {
    }

    public PatientDTO(Long id, String nom, String prenom, String sexe, String dateNaissance, String lieuNaissance, String telephone, String email, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
    }

    public PatientDTO(Long id, String nom, String prenom, String sexe, String dateNaissance, String lieuNaissance, String telephone, String email, String adresse, Long dossierMedicalId) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.dossierMedicalId = dossierMedicalId;
    }

    public PatientDTO(Long id, String nom, String prenom, String sexe, String dateNaissance, String lieuNaissance, String telephone, String email, String adresse, DossierMedical dossierMedical) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.dossierMedical = dossierMedical;
    }

    public PatientDTO(Long id, String nom, String prenom, String sexe, String dateNaissance, String lieuNaissance, String telephone, String email, String adresse, String profession, String groupe_sanguin, Long dossierMedicalId, DossierMedical dossierMedical, Long personnel_id) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
        this.profession = profession;
        this.groupe_sanguin = groupe_sanguin;
        this.dossierMedicalId = dossierMedicalId;
        this.dossierMedical = dossierMedical;
        this.personnel_id = personnel_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getDossierMedicalId() {
        return dossierMedicalId;
    }

    public void setDossierMedicalId(Long dossierMedicalId) {
        this.dossierMedicalId = dossierMedicalId;
    }

    public DossierMedical getDossierMedical() {
        return dossierMedical;
    }

    public void setDossierMedical(DossierMedical dossierMedical) {
        this.dossierMedical = dossierMedical;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getGroupe_sanguin() {
        return groupe_sanguin;
    }

    public void setGroupe_sanguin(String groupe_sanguin) {
        this.groupe_sanguin = groupe_sanguin;
    }

    public Long getPersonnel_id() {
        return personnel_id;
    }

    public void setPersonnel_id(Long personnel_id) {
        this.personnel_id = personnel_id;
    }
}
