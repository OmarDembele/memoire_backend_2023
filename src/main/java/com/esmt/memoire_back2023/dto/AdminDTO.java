package com.esmt.memoire_back2023.dto;


import com.esmt.memoire_back2023.entity.UserRole;

public class AdminDTO {

    private Long idAdmin;
    private String nom;
    private String prenom;
    private String sexe;
    private String lieuNaissance;
    private String numLicence;

    private UserRole role;
    private String login;
    private String password;
    private String specialite;
    private Long status;
    public AdminDTO() {
    }

    public AdminDTO(Long idAdmin, String nom, String prenom, String sexe, String lieuNaissance, String numLicence, UserRole role, String login, String password, String specialite, Long status) {
        this.idAdmin = idAdmin;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.lieuNaissance = lieuNaissance;
        this.numLicence = numLicence;
        this.role = role;
        this.login = login;
        this.password = password;
        this.specialite = specialite;
        this.status = status;
    }

    public Long getIdAdmin() {
        return idAdmin;
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

    public UserRole getRole() {
        return role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getSpecialite() {
        return specialite;
    }

    public Long getStatus() {
        return status;
    }

    public void setIdAdmin(Long idAdmin) {
        this.idAdmin = idAdmin;
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

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setStatus(Long status) {
        this.status = status;
    }
}

//private UtilisateurDTO utilisateurDTO;