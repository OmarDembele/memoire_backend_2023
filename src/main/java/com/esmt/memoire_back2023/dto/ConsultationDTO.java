package com.esmt.memoire_back2023.dto;

public class ConsultationDTO {

    private Long id;
    private Long patientId;
    private Long medecinTraitantId;
    private Long medecinConsultantId;
    private Long medecinChirurgienId;
    private String antecedentsMedicaux;
    private String anciensTraitements;
    private Long personnelId;

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

    public ConsultationDTO() {
    }

    public ConsultationDTO(Long id, Long patientId, Long medecinTraitantId, Long medecinConsultantId, Long medecinChirurgienId, String antecedentsMedicaux, String anciensTraitements, String diagnostic, String description) {
        this.id = id;
        this.patientId = patientId;
        this.medecinTraitantId = medecinTraitantId;
        this.medecinConsultantId = medecinConsultantId;
        this.medecinChirurgienId = medecinChirurgienId;
        this.antecedentsMedicaux = antecedentsMedicaux;
        this.anciensTraitements = anciensTraitements;
        this.diagnostic = diagnostic;
        this.description = description;
    }

    public ConsultationDTO(Long id, Long patientId, Long medecinTraitantId, Long medecinConsultantId, Long medecinChirurgienId, String antecedentsMedicaux, String anciensTraitements, Long personnelId, String diagnostic, String description) {
        this.id = id;
        this.patientId = patientId;
        this.medecinTraitantId = medecinTraitantId;
        this.medecinConsultantId = medecinConsultantId;
        this.medecinChirurgienId = medecinChirurgienId;
        this.antecedentsMedicaux = antecedentsMedicaux;
        this.anciensTraitements = anciensTraitements;
        this.personnelId = personnelId;
        this.diagnostic = diagnostic;
        this.description = description;
    }

    public ConsultationDTO(Long id, Long patientId, Long medecinTraitantId, Long medecinConsultantId, Long medecinChirurgienId, String antecedentsMedicaux, String anciensTraitements, Long personnelId, String antecedent, String ancientraitement, String dateconsultation, String diagnostic, String description) {
        this.id = id;
        this.patientId = patientId;
        this.medecinTraitantId = medecinTraitantId;
        this.medecinConsultantId = medecinConsultantId;
        this.medecinChirurgienId = medecinChirurgienId;
        this.antecedentsMedicaux = antecedentsMedicaux;
        this.anciensTraitements = anciensTraitements;
        this.personnelId = personnelId;
        this.antecedent = antecedent;
        this.ancientraitement = ancientraitement;
        this.dateconsultation = dateconsultation;
        this.diagnostic = diagnostic;
        this.description = description;
    }

    public ConsultationDTO(Long id, Long patientId, Long medecinTraitantId, Long medecinConsultantId, Long medecinChirurgienId, String antecedentsMedicaux, String anciensTraitements, Long personnelId, String poids, String taille, String nameurgence, String adresse, String telephone, String antecedent, String ancientraitement, String dateconsultation, String diagnostic, String description) {
        this.id = id;
        this.patientId = patientId;
        this.medecinTraitantId = medecinTraitantId;
        this.medecinConsultantId = medecinConsultantId;
        this.medecinChirurgienId = medecinChirurgienId;
        this.antecedentsMedicaux = antecedentsMedicaux;
        this.anciensTraitements = anciensTraitements;
        this.personnelId = personnelId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getMedecinTraitantId() {
        return medecinTraitantId;
    }

    public void setMedecinTraitantId(Long medecinTraitantId) {
        this.medecinTraitantId = medecinTraitantId;
    }

    public Long getMedecinConsultantId() {
        return medecinConsultantId;
    }

    public void setMedecinConsultantId(Long medecinConsultantId) {
        this.medecinConsultantId = medecinConsultantId;
    }

    public Long getMedecinChirurgienId() {
        return medecinChirurgienId;
    }

    public void setMedecinChirurgienId(Long medecinChirurgienId) {
        this.medecinChirurgienId = medecinChirurgienId;
    }

    public String getAntecedentsMedicaux() {
        return antecedentsMedicaux;
    }

    public void setAntecedentsMedicaux(String antecedentsMedicaux) {
        this.antecedentsMedicaux = antecedentsMedicaux;
    }

    public String getAnciensTraitements() {
        return anciensTraitements;
    }

    public void setAnciensTraitements(String anciensTraitements) {
        this.anciensTraitements = anciensTraitements;
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

    public Long getPersonnelId() {
        return personnelId;
    }

    public void setPersonnelId(Long personnelId) {
        this.personnelId = personnelId;
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
