package com.esmt.memoire_back2023.dto;



public class NextRvDTO {

    private Long id;
    private Long dossierid;

    private String medecinassigne;

    private String heurerv;

    private String daterv;

    public NextRvDTO() {
    }

    public NextRvDTO(Long id, Long dossierid, String medecinassigne, String heurerv, String daterv) {
        this.id = id;
        this.dossierid = dossierid;
        this.medecinassigne = medecinassigne;
        this.heurerv = heurerv;
        this.daterv = daterv;
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
}

