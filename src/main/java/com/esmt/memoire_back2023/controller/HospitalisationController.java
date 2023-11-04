package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.HospitalisationDTO;
import com.esmt.memoire_back2023.entity.Hospitalisation;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.repository.HospitalisationRepository;
import com.esmt.memoire_back2023.services.HospitalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/hospitalisation")
public class HospitalisationController {

    @Autowired
    private HospitalisationService hospitalisationService;

    @Autowired
    private HospitalisationRepository hospitalisationRepository;

    @Autowired
    private DossierRepository dossierRepository;

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

    @GetMapping("/dossier/{dossier_medical_id}/hospitalisations")
    public ResponseEntity<List<Hospitalisation>> getAllHospiByDossierId(@PathVariable(value = "dossier_medical_id") Long dossier_medical_id) {
        if (!dossierRepository.existsById(dossier_medical_id)) {
            throw new RuntimeException("Not found Tutorial with id = " + dossier_medical_id);
        }
        List<Hospitalisation> hospitalisations = hospitalisationRepository.findByDossierMedicalId(dossier_medical_id);
        return new ResponseEntity<>(hospitalisations, HttpStatus.OK);
    }
}
