package com.esmt.memoire_back2023.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "nextRv")
public class NextRv {

    @Id
    @Column(name = "id", length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dossier_id", length = 45)
    private Long dossierid;

    @Column(name = "medecin_assigne", length = 45)
    private String medecinassigne;

    @Column(name = "heure_rv", length = 45)
    private String heurerv;

    @Column(name = "date_rv", length = 45)
    private String daterv;

    private Long personnel;

    public NextRv() {
    }

    public NextRv(Long id, Long dossierid, String medecinassigne, String heurerv, String daterv, Long personnel) {
        this.id = id;
        this.dossierid = dossierid;
        this.medecinassigne = medecinassigne;
        this.heurerv = heurerv;
        this.daterv = daterv;
        this.personnel = personnel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDossierid() {
        return dossierid;
    }

    public void setDossierid(Long dossierid) {
        this.dossierid = dossierid;
    }

    public String getMedecinassigne() {
        return medecinassigne;
    }

    public void setMedecinassigne(String medecinassigne) {
        this.medecinassigne = medecinassigne;
    }

    public String getHeurerv() {
        return heurerv;
    }

    public void setHeurerv(String heurerv) {
        this.heurerv = heurerv;
    }

    public String getDaterv() {
        return daterv;
    }

    public void setDaterv(String daterv) {
        this.daterv = daterv;
    }

    public Long getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Long personnel) {
        this.personnel = personnel;
    }
}
