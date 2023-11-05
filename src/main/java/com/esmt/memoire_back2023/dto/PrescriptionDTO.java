package com.esmt.memoire_back2023.dto;


public class PrescriptionDTO {

    private Long id;

    private Long dossier_medicalId;

    private Long personnel;

    private String type;

    private String instruction;


    public PrescriptionDTO() {
    }

    public PrescriptionDTO(Long id, Long dossierMedical_id, String type, String instruction, Long personnel) {
        this.id = id;
        this.dossier_medicalId = dossierMedical_id;
        this.type = type;
        this.instruction = instruction;
        this.personnel = personnel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getDossier_medicalId() {
        return dossier_medicalId;
    }

    public void setDossier_medicalId(Long dossier_medicalId) {
        this.dossier_medicalId = dossier_medicalId;
    }

    public Long getPersonnel() {
        return personnel;
    }

    public void setPerosnnel(Long personnel) {
        this.personnel = personnel;
    }
}

