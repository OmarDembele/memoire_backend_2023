package com.esmt.memoire_back2023.dto;


public class DossierDTO {

    private Long IdDossier;

    private String numero_dossier;

    private String dateCreation;

    private String description;

    public DossierDTO() {
    }

    public DossierDTO(Long idDossier, String dateCreation, String description) {
        IdDossier = idDossier;
        this.dateCreation = dateCreation;
        this.description = description;
    }

    public DossierDTO(Long idDossier, String numero_dossier, String dateCreation, String description) {
        IdDossier = idDossier;
        this.numero_dossier = numero_dossier;
        this.dateCreation = dateCreation;
        this.description = description;
    }

    public Long getIdDossier() {
        return IdDossier;
    }

    public void setIdDossier(Long idDossier) {
        IdDossier = idDossier;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumero_dossier() {
        return numero_dossier;
    }

    public void setNumero_dossier(String numero_dossier) {
        this.numero_dossier = numero_dossier;
    }

}

