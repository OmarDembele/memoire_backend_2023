package com.esmt.memoire_back2023.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "ExamenMedicale")
public class ExamenMedical {

    @Id
    @Column(name = "idExamen", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String resultat;

    @ManyToOne
    @JoinColumn(name = "dossier_medical_id")
    @JsonIgnore
    private DossierMedical dossier_medical_id;

    public ExamenMedical() {
    }

    public ExamenMedical(Long id, String type, String resultat) {
        this.id = id;
        this.type = type;
        this.resultat = resultat;
    }

    public ExamenMedical(Long id, String type, String resultat, DossierMedical dossierMedical_id) {
        this.id = id;
        this.type = type;
        this.resultat = resultat;
        this.dossier_medical_id = dossierMedical_id;
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

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public DossierMedical getDossierMedical_id() {
        return dossier_medical_id;
    }

    public void setDossierMedical_id(DossierMedical dossierMedical_id) {
        this.dossier_medical_id = dossierMedical_id;
    }
}
