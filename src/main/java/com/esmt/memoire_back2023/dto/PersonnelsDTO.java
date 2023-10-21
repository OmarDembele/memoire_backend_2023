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
    private UserRole type;
    private Long status;
    private String role;
    private String specialite;
    private String etat;

    public PersonnelsDTO() {
    }

    public PersonnelsDTO(Long idPersonnel, String nom, String prenom, String sexe, String lieuNaissance, String numLicence, String login, String password, UserRole type, Long status, String role, String specialite, String etat) {
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

    public UserRole getType() {
        return type;
    }

    public Long getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

    public String getSpecialite() {
        return specialite;
    }

    public String getEtat() {
        return etat;
    }
}

//private UtilisateurDTO utilisateurDTO;