package com.esmt.memoire_back2023.dto;

import com.esmt.memoire_back2023.entity.UserRole;


public class AdminDTO {

    private Long idAdmin;
    private String nom;
    private String prenom;
    private String sexe;
    private String lieuNaissance;
    private String numLicence;
    private String login;
    private String password;
    private UserRole type;
    private Long status;
    private String role;

    public AdminDTO() {
    }

    public AdminDTO(Long idAdmin, String nom, String prenom, String sexe, String lieuNaissance, String numLicence, String login, String password, UserRole type, Long status, String role) {
        this.idAdmin = idAdmin;
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

    public UserRole getType() {
        return type;
    }

    public Long getStatus() {
        return status;
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

    public void setType(UserRole type) {
        this.type = type;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getIdAdmin() {
        return idAdmin;
    }

    public String getRole() {
        return role;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public void setRole(String role) {
        this.role = role;
    }


}

//private UtilisateurDTO utilisateurDTO;