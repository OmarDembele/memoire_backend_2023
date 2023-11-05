package com.esmt.memoire_back2023.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Personnels")
public class Personnels{

    @Id
    @Column(name = "idPersonnel", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonnel;

    @Column(name = "nom", length = 255)
    private String nom;

    @Column(name = "prenom", length = 255)
    private String prenom;

    @Column(name = "sexe", length = 255)
    private String sexe;

    @Column(name = "lieuNaissance", length = 255)
    private String lieuNaissance;

    @Column(name = "dateNaissance", length = 255)
    private String dateNaissance;

    @Column(name = "adresse", length = 255)
    private String adresse;

    @Column(name = "telephone", length = 255)
    private String telephone;

    @Column(name = "numLicence", length = 255)
    private String numLicence;

    @Column(name = "login", length = 255)
    private String login;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "rolePersonnel", length = 255)
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "specialite", length = 255)
    private String specialite;

    @Column(name = "etat", length = 255)
    private String etat;

    @Column(name = "dateInscription", length = 255)
    private String dateInscription;

    public Personnels() {
    }

    public Personnels(Long idPersonnel, String nom, String prenom, String sexe,String dateInscription, String lieuNaissance, String dateNaissance, String adresse, String telephone, String numLicence, String login, String password, UserRole role, String specialite, String etat) {
        this.idPersonnel = idPersonnel;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.lieuNaissance = lieuNaissance;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.telephone = telephone;
        this.numLicence = numLicence;
        this.login = login;
        this.password = password;
        this.role = role;
        this.specialite = specialite;
        this.etat = etat;
        this.dateInscription = dateInscription;

    }

    public Personnels(Long medecinTraitantId) {
    }

    public Long getIdPersonnel() {
        return idPersonnel;
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

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getDateNaissance() {
        return dateNaissance;
    }
    public String getAdresse() {
        return adresse;
    }
    public String getTelephone() {
        return telephone;
    }


    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
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

   public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setIdPersonnel(Long idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

}

