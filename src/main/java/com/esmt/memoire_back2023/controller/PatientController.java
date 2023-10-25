package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.PatientDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.repository.PatientRepository;
import com.esmt.memoire_back2023.services.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DossierRepository dossierRepository;

    @Autowired
    private PatientRepository patientRepository;

    public PatientController(PatientService patientService, DossierRepository dossierRepository, PatientRepository patientRepository) {
        this.patientService = patientService;
        this.dossierRepository = dossierRepository;
        this.patientRepository = patientRepository;
    }


    @PostMapping(path = "/save")
    public Long addPatient(@RequestBody PatientDTO patientDTO) {
        Patient patient = patientService.creerPatients(patientDTO);
        return new ResponseEntity<>(patient.getIdPatient(), HttpStatus.CREATED).getBody();
    }
}
