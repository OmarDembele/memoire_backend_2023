package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.PatientDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Patient;
import java.util.List;

public interface PatientService {
    Patient creerPatients(PatientDTO patientDTO);

    Patient obtenirPatientParId(Long id);

   Patient updatePatient(Long id, PatientDTO patientDTO);

    void deletePatient(Long id);

    List<Patient> getPatients();

    List<Patient> getPatientByPersonnel(Long personnelId);

    List<Patient> getPatientsByDossierMedical(DossierMedical dossierMedicalId);


}
