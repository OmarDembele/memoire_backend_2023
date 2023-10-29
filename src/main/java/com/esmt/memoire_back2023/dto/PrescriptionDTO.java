package com.esmt.memoire_back2023.dto;


public class PrescriptionDTO {

    private Long id;

    private Long dossierMedical_id;

    private String type;

    private String instruction;

    public PrescriptionDTO() {
    }

    public PrescriptionDTO(Long id, Long dossierMedical_id, String type, String instruction) {
        this.id = id;
        this.dossierMedical_id = dossierMedical_id;
        this.type = type;
        this.instruction = instruction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDossierMedical_id() {
        return dossierMedical_id;
    }

    public void setDossierMedical_id(Long dossierMedical_id) {
        this.dossierMedical_id = dossierMedical_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}

