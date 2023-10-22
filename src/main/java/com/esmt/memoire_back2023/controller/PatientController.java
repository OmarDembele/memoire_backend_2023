package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.PatientDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DossierRepository dossierRepository;

    public PatientController(PatientService patientService, DossierRepository dossierRepository) {
        this.patientService = patientService;
        this.dossierRepository = dossierRepository;
    }


    @PostMapping(path = "/save")
    public Patient addPatient(@RequestBody PatientDTO patientDTO) {
        Patient patient = patientService.creerPatients(patientDTO);
        return patient;
    }
}
