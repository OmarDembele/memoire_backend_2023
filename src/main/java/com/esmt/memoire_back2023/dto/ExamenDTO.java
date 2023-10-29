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

    private Long dossierMedical_id;

    public ExamenDTO() {
    }

    public ExamenDTO(Long id, String type, String resultat) {
        this.id = id;
        this.type = type;
        this.resultat = resultat;
    }

    public ExamenDTO(Long id, String type, String resultat, Long dossierMedical_id) {
        this.id = id;
        this.type = type;
        this.resultat = resultat;
        this.dossierMedical_id = dossierMedical_id;
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

    public Long getDossierMedical_id() {
        return dossierMedical_id;
    }

    public void setDossierMedical_id(Long dossierMedical_id) {
        this.dossierMedical_id = dossierMedical_id;
    }
}

