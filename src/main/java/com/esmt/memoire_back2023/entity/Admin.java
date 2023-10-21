package com.esmt.memoire_back2023.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Admin")
public class Admin{

    @Id
    @Column(name = "idAdmin", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAdmin;

    @Column(name = "nom", length = 255)
    private String nom;

    @Column(name = "prenom", length = 255)
    private String prenom;

    @Column(name = "sexe", length = 255)
    private String sexe;

    @Column(name = "lieuNaissance", length = 255)
    private String lieuNaissance;

    @Column(name = "numLicence", length = 255)
    private String numLicence;

    @Column(name = "roleAdmin", length = 255)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "login", length = 255)
    private String login;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "status", length = 45)
    private Long status;

    @Column(name = "specialite", length = 255)
    private String specialite;

    public Admin() {
    }

    public Admin(Long idAdmin, String nom, String prenom, String sexe, String lieuNaissance, String numLicence, UserRole role, String login, String password, Long status, String specialite) {
        this.idAdmin = idAdmin;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.lieuNaissance = lieuNaissance;
        this.numLicence = numLicence;
        this.role = role;
        this.login = login;
        this.password = password;
        this.status = status;
        this.specialite = specialite;
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

    public Long getStatus() {
        return status;
    }

    public String getSpecialite() {
        return specialite;
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

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

/*
    @OneToOne
    @JoinColumn(name = "user_id")
    private Utilisateur utilisateur;

    */


