package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.PatientDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.repository.PatientRepository;
import com.esmt.memoire_back2023.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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
    public Patient addPatient(@RequestBody PatientDTO patientDTO) {
        Patient patient = patientService.creerPatients(patientDTO);
        return new ResponseEntity<>(patient, HttpStatus.CREATED).getBody();
    }

    @GetMapping("")
    public List<Patient> getPatientsByPersonnelId() {
        return patientService.getPatients();
    }


    @DeleteMapping("/{id}")
    public void supprimerPatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

    @GetMapping(path = "/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.obtenirPatientParId(id);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody PatientDTO patientDTO) {
        Patient updatedPatient = patientService.updatePatient(id, patientDTO);
        if (updatedPatient != null) {
            return ResponseEntity.ok(updatedPatient);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/byPersonnelId/{personnelId}")
    public List<Patient> getPatientsByPersonnelId(@PathVariable Long personnelId) {
        List<Patient> patients = patientService.getPatientByPersonnel(personnelId);
        return patients;
    }

    @GetMapping("/patients/{dossierMedicalId}")
    public List<Patient> getPatients(@PathVariable DossierMedical dossierMedicalId) {
        List<Patient> patients = patientService.getPatientsByDossierMedical(dossierMedicalId);
        return patients;
    }

}