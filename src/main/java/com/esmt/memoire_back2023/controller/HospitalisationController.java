package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.HospitalisationDTO;
import com.esmt.memoire_back2023.entity.Hospitalisation;
import com.esmt.memoire_back2023.services.HospitalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/hospitalisation")
public class HospitalisationController {

    @Autowired
    private HospitalisationService hospitalisationService;

    public HospitalisationController(HospitalisationService hospitalisationService) {
        this.hospitalisationService = hospitalisationService;
    }

    @PostMapping(path = "/save")
    private Hospitalisation addHospi(@RequestBody HospitalisationDTO hospitalisationDTO){
        Hospitalisation hospitalisation = hospitalisationService.creerHospi(hospitalisationDTO);
        return hospitalisation;
    }

    @DeleteMapping("/{id}")
    public void supprimerHospi(@PathVariable Long id) {
        hospitalisationService.deleteHospi(id);
    }

    @GetMapping("")
    public List<Hospitalisation> getAllHospitalisation() {
        return hospitalisationService.getAllHospi();

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Hospitalisation> updateHospi(@PathVariable Long id, @RequestBody HospitalisationDTO hospitalisationDTO) {
        Hospitalisation updateHospi = hospitalisationService.updateHospi(id, hospitalisationDTO);
        if (updateHospi != null) {
            return ResponseEntity.ok(updateHospi);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dossier/{dossierMedicalId}")
    public List<Hospitalisation> getConsultationsByDossierMedical(@PathVariable Long dossierMedicalId) {
        List<Hospitalisation> hospitalisations = hospitalisationService.getHospitalisationsByDossierMedical(dossierMedicalId);
        return hospitalisations;
    }

    @GetMapping(path = "/{id}")
    public Hospitalisation getConsultationById(@PathVariable Long id) {
        return hospitalisationService.getHospitalisationById(id);
    }

}
