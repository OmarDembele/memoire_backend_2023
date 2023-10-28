package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.DossierDTO;
import com.esmt.memoire_back2023.dto.PatientDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.repository.PatientRepository;
import com.esmt.memoire_back2023.services.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    private Patient convertDTOToEntity(PatientDTO patientDTO) {
        Patient patient = new Patient();

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

        }
        return patient;
    }

    @Override
    public List<PatientDTO> obtenirTousLesPatients() {
        // Récupérer les entités depuis la base de données
        List<Patient> patients = patientRepository.findAll();

        // Convertir les entités en DTOs
        List<PatientDTO> patientDTOS = patients.stream()
                .map(patient -> new PatientDTO(
                        patient.getIdPatient(),
                        patient.getNom(),
                        patient.getPrenom(),
                        patient.getSexe(),
                        patient.getLieuNaissance(),
                        patient.getDateNaissance(),
                        patient.getAdresse(),
                        patient.getEmail(),
                        patient.getTelephone()
                ))
                .collect(Collectors.toList());

        return patientDTOS;
    }
}
