package com.esmt.memoire_back2023.dto;

import com.esmt.memoire_back2023.entity.DossierMedical;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ExamenDTO {

    private Long id;

    private String type;

    private String resultat;

    private Long dossier_medical_id;

    private Long personnel;

    public ExamenDTO() {
    }

    public ExamenDTO(Long id, String type, String resultat) {
        this.id = id;
        this.type = type;
        this.resultat = resultat;
    }

    public ExamenDTO(Long id, String type, String resultat, Long dossierMedical_id, Long personnel) {
        this.id = id;
        this.type = type;
        this.resultat = resultat;
        this.dossier_medical_id = dossierMedical_id;
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

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public Long getDossier_medical_id() {
        return dossier_medical_id;
    }

    public void setDossier_medical_id(Long dossier_medical_id) {
        this.dossier_medical_id = dossier_medical_id;
    }

    public Long getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Long personnel) {
        this.personnel = personnel;
    }
}

