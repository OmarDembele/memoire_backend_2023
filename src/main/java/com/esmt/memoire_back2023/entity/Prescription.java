package com.esmt.memoire_back2023.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "prescription")
public class Prescription {

    @Id
    @Column(name = "id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private DossierMedical dossierMedical_id;

    private String type;

    private String instruction;

    public Prescription() {
    }

    public Prescription(Long id, DossierMedical dossierMedical_id, String type, String instruction) {
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

    public DossierMedical getDossierMedical_id() {
        return dossierMedical_id;
    }

    public void setDossierMedical_id(DossierMedical dossierMedical_id) {
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
