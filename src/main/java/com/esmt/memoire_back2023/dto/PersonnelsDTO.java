package com.esmt.memoire_back2023.dto;

import com.esmt.memoire_back2023.entity.UserRole;

public class PersonnelsDTO {

    private Long idPersonnel;
    private String nom;
    private String prenom;
    private String sexe;
    private String lieuNaissance;
    private String numLicence;
    private String login;
    private String password;
    private UserRole role;
    private Long status;
    private String type;
    private String specialite;
    private String etat;

    public PersonnelsDTO() {
    }

    public PersonnelsDTO(Long idPersonnel, String nom, String prenom, String sexe, String lieuNaissance, String numLicence, String login, String password, String type, Long status, UserRole role, String specialite, String etat) {
        this.idPersonnel = idPersonnel;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.lieuNaissance = lieuNaissance;
        this.numLicence = numLicence;
        this.login = login;
        this.password = password;
        this.type = type;
        this.status = status;
        this.role = role;
        this.specialite = specialite;
        this.etat = etat;
    }

    public Long getIdPersonnel() {
        return idPersonnel;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public String getNumLicence() {
        return numLicence;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getType() {
        return type;
    }

    public Long getStatus() {
        return status;
    }

    public UserRole getRole() {
        return role;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getEtat() {
        return etat;
    }

    public void setIdPersonnel(Long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public void setNumLicence(String numLicence) {
        this.numLicence = numLicence;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}

//private UtilisateurDTO utilisateurDTO;