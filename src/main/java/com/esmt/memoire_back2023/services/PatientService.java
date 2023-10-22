package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.DossierDTO;
import com.esmt.memoire_back2023.dto.PatientDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Patient;

public interface PatientService {
    Patient creerPatients(PatientDTO patientDTO);

}
