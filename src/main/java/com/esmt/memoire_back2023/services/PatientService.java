package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.PatientDTO;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.entity.Personnels;

import java.util.List;

import java.util.List;

public interface PatientService {
    Patient creerPatients(PatientDTO patientDTO);

    List<PatientDTO> obtenirTousLesPatients();


    PatientDTO obtenirPatientParId(Long id);

   Patient updatePatient(Long id, PatientDTO patientDTO);

    void deletePatient(Long id);

    List<Patient> getPatients();


}
