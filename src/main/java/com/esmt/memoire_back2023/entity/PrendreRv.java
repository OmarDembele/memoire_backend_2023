package com.esmt.memoire_back2023.entity;

import jakarta.persistence.*;

@Entity
public class PrendreRv {

    @Id
    @Column(name = "id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom", length = 255)
    private String nom;

    @Column(name = "prenom", length = 255)
    private String prenom;

    @Column(name = "sexe", length = 255)
    private String sexe;

    @Column(name = "dateNaissance", length = 255)
    private String dateNaissance;

    @Column(name = "lieuNaissance", length = 255)
    private String lieuNaissance;

    @Column(name = "telephone", length = 255)
    private String telephone;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "adresse", length = 255)
    private String adresse;

    @Column(name = "profession", length = 255)
    private String profession;

    @Column(name = "heureRv", length = 255)
    private String heureRv;

    @Column(name = "dateRv", length = 255)
    private String dateRv;

    public PrendreRv() {
    }

    public PrendreRv(Long id, String nom, String prenom, String sexe, String dateNaissance, String lieuNaissance, String telephone, String email, String adresse, String profession, String heureRv, String dateRv) {
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
        this.heureRv = heureRv;
        this.dateRv = dateRv;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getHeureRv() {
        return heureRv;
    }

    public void setHeureRv(String heureRv) {
        this.heureRv = heureRv;
    }

    public String getDateRv() {
        return dateRv;
    }

    public void setDateRv(String dateRv) {
        this.dateRv = dateRv;
    }
}
