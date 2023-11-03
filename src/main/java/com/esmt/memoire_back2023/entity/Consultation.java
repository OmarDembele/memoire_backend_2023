package com.esmt.memoire_back2023.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Consultation {
    @Id
    @Column(name = "idConsultation", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idConsultation;


    @OneToOne(cascade = CascadeType.ALL)
    private DossierMedical dossierMedical_id;

    @ManyToMany(mappedBy = "consultations", cascade = CascadeType.REMOVE)
    private Set<Patient> patients = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "medecin_traitant_id")
    private Personnels medecinTraitant;

    @ManyToOne
    @JoinColumn(name = "medecin_consultant_id")
    private Personnels medecinConsultant;

    @ManyToOne
    @JoinColumn(name = "medecin_chirurgien_id")
    private Personnels medecinChirurgien;

    private String poids;

    private String taille;

    private String nameurgence;

    private String adresse;

    private String telephone;

    private String antecedent;

    private String ancientraitement;

    private String dateconsultation;

    private String diagnostic;
    private String description;



    public Consultation() {
    }

    public Consultation(Long idConsultation, String diagnostic, String description) {
        this.idConsultation = idConsultation;
        this.diagnostic = diagnostic;
        this.description = description;
    }

    public Consultation(Long idConsultation, Set<Patient> patients, String diagnostic, String description) {
        this.idConsultation = idConsultation;
        this.patients = patients;
        this.diagnostic = diagnostic;
        this.description = description;
    }

    public Consultation(Long idConsultation, Set<Patient> patients, Personnels medecinTraitant, Personnels medecinConsultant, Personnels medecinChirurgien, String diagnostic, String description) {
        this.idConsultation = idConsultation;
        this.patients = patients;
        this.medecinTraitant = medecinTraitant;
        this.medecinConsultant = medecinConsultant;
        this.medecinChirurgien = medecinChirurgien;
        this.diagnostic = diagnostic;
        this.description = description;
    }

    public Consultation(Long idConsultation, Set<Patient> patients, Personnels medecinTraitant, Personnels medecinConsultant, Personnels medecinChirurgien, String antecedent, String ancientraitement, String diagnostic, String description, String dateconsultation) {
        this.idConsultation = idConsultation;
        this.patients = patients;
        this.medecinTraitant = medecinTraitant;
        this.medecinConsultant = medecinConsultant;
        this.medecinChirurgien = medecinChirurgien;
        this.antecedent = antecedent;
        this.ancientraitement = ancientraitement;
        this.diagnostic = diagnostic;
        this.description = description;
        this.dateconsultation = dateconsultation;
    }

    public Consultation(Long idConsultation, Set<Patient> patients, DossierMedical dossierMedical_id, Personnels medecinTraitant, Personnels medecinConsultant, Personnels medecinChirurgien, String poids, String taille, String nameurgence, String adresse, String telephone, String antecedent, String ancientraitement, String dateconsultation, String diagnostic, String description) {
        this.idConsultation = idConsultation;
        this.patients = patients;
        this.dossierMedical_id = dossierMedical_id;
        this.medecinTraitant = medecinTraitant;
        this.medecinConsultant = medecinConsultant;
        this.medecinChirurgien = medecinChirurgien;
        this.poids = poids;
        this.taille = taille;
        this.nameurgence = nameurgence;
        this.adresse = adresse;
        this.telephone = telephone;
        this.antecedent = antecedent;
        this.ancientraitement = ancientraitement;
        this.dateconsultation = dateconsultation;
        this.diagnostic = diagnostic;
        this.description = description;
    }

    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
    }

    public DossierMedical getDossierMedical_id() {
        return dossierMedical_id;
    }

    public void setDossierMedical_id(DossierMedical dossierMedical_id) {
        this.dossierMedical_id = dossierMedical_id;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public Personnels getMedecinTraitant() {
        return medecinTraitant;
    }

    public void setMedecinTraitant(Personnels medecinTraitant) {
        this.medecinTraitant = medecinTraitant;
    }

    public Personnels getMedecinConsultant() {
        return medecinConsultant;
    }

    public void setMedecinConsultant(Personnels medecinConsultant) {
        this.medecinConsultant = medecinConsultant;
    }

    public Personnels getMedecinChirurgien() {
        return medecinChirurgien;
    }

    public void setMedecinChirurgien(Personnels medecinChirurgien) {
        this.medecinChirurgien = medecinChirurgien;
    }

    public String getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(String antecedent) {
        this.antecedent = antecedent;
    }

    public String getAncientraitement() {
        return ancientraitement;
    }

    public void setAncientraitement(String ancientraitement) {
        this.ancientraitement = ancientraitement;
    }

    public String getDateconsultation() {
        return dateconsultation;
    }

    public void setDateconsultation(String dateconsultation) {
        this.dateconsultation = dateconsultation;
    }

    public String getPoids() {
        return poids;
    }

    public void setPoids(String poids) {
        this.poids = poids;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getNameurgence() {
        return nameurgence;
    }

    public void setNameurgence(String nameurgence) {
        this.nameurgence = nameurgence;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}

