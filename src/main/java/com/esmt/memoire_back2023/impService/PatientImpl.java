package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.PatientDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.repository.PatientRepository;
import com.esmt.memoire_back2023.services.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PatientImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DossierRepository dossierMedicalRepository;

    public PatientImpl(PatientRepository patientRepository, DossierRepository dossierMedicalRepository) {
        this.patientRepository = patientRepository;
        this.dossierMedicalRepository = dossierMedicalRepository;
    }

    @Override
    public Patient creerPatients(PatientDTO patientDTO) {
        Patient patient = convertDTOToEntity(patientDTO);
        patientRepository.save(patient);
        return patient;
    }

    private Patient convertDTOToEntity(PatientDTO patientDTO){
        Patient patient = new Patient();
        DossierMedical dossierMedical = new DossierMedical();

        patient.setNom(patientDTO.getNom());
        patient.setPrenom(patientDTO.getPrenom());
        patient.setSexe(patientDTO.getSexe());
        patient.setLieuNaissance(patientDTO.getLieuNaissance());
        patient.setDateNaissance(patientDTO.getDateNaissance());
        patient.setAdresse(patientDTO.getAdresse());
        patient.setEmail(patientDTO.getEmail());
        patient.setTelephone(patientDTO.getTelephone());

        if (patientDTO.getDossierMedicalId() != null) {
            DossierMedical dossierMedical1 = dossierMedicalRepository.findById(patientDTO.getDossierMedicalId())
                    .orElseThrow(() -> new EntityNotFoundException("DossierMedical non trouvé avec l'ID : " + patientDTO.getDossierMedicalId()));
            patient.setDossierMedical(dossierMedical1);
        } else {
            patient.setDossierMedical(patientDTO.getDossierMedical());
        }
        return  patient;
    }
}
