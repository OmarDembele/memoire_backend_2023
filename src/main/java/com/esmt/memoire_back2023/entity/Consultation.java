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

    @ManyToMany(mappedBy = "consultations")
    private Set<Patient> patients = new HashSet<>();

    private String diagnostic;
    private String description;

    public Consultation() {
    }

    public Consultation(Long idConsultation, String diagnostic, String description) {
        this.idConsultation = idConsultation;
        this.diagnostic = diagnostic;
        this.description = description;
    }

    public Long getIdConsultation() {
        return idConsultation;
    }

    public void setIdConsultation(Long idConsultation) {
        this.idConsultation = idConsultation;
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
}

