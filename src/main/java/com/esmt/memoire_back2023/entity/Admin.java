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

    @Column(name = "login", length = 255)
    private String login;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "type", length = 255)
    @Enumerated(EnumType.STRING)
    private UserRole type;

    @Column(name = "status", length = 45)
    private Long status;

    @Column(name = "roleAdmin", length = 255)
    private String role;

    public Admin() {
    }

    public Admin(Long idAdmin, String nom, String prenom, String sexe, String lieuNaissance, String numLicence, String login, String password, UserRole type, Long status, String role) {
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

    public void setType(UserRole type) {
        this.type = type;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

/*
    @OneToOne
    @JoinColumn(name = "user_id")
    private Utilisateur utilisateur;

    */


