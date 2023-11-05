package com.esmt.memoire_back2023.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Patients")
public class Patient {
    @Id
    @Column(name = "idPatient", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

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

    @Column(name = "groupe_sanguin", length = 255)
    private String groupe_sanguin;

    @OneToOne(cascade = CascadeType.ALL)
    private DossierMedical dossierMedical;

    private Long personnel_id;

    public Patient() {
    }

    public Patient(Long idPatient, String nom, String prenom, String sexe, String dateNaissance, String lieuNaissance, String telephone, String email, String adresse) {
        this.idPatient = idPatient;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
    }

    public Patient(Long idPatient, String nom, String prenom, String sexe, String dateNaissance, String lieuNaissance, String telephone, String email, String adresse, DossierMedical dossierMedical) {
        this.idPatient = idPatient;
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

    public Patient(Long idPatient, String nom, String prenom, String sexe,String dateCreation, String dateNaissance, String lieuNaissance, String telephone, String email, String adresse, String profession, String groupe_sanguin, DossierMedical dossierMedical, Long personnel_id) {
        this.idPatient = idPatient;
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
        this.dossierMedical = dossierMedical;

        this.personnel_id = personnel_id;
    }

    public Patient(Long patientId) {
    }

    public Long getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Long idPatient) {
        this.idPatient = idPatient;
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
