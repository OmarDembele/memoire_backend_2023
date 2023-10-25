package com.esmt.memoire_back2023.dto;

public class ConsultationDTO {

    private Long id;
    private Long patientId;
    private Long medecinTraitantId;
    private Long medecinConsultantId;
    private Long medecinChirurgienId;
    private String antecedentsMedicaux;
    private String anciensTraitements;
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
}
