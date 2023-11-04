package com.esmt.memoire_back2023.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @Column(name = "id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String instruction;

    private Long dossier_medicalId;

    public Prescription() {
    }

    public Prescription(Long id, Long dossierMedical_id, String type, String instruction) {
        this.id = id;
        this.dossier_medicalId = dossierMedical_id;
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
        return dossier_medicalId;
    }

    public void setDossierMedical_id(Long dossierMedical_id) {
        this.dossier_medicalId = dossierMedical_id;
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
