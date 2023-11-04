package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.PatientDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.entity.Personnels;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.repository.PatientRepository;
import com.esmt.memoire_back2023.repository.PersonnelsRepository;
import com.esmt.memoire_back2023.services.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DossierRepository dossierMedicalRepository;

    @Autowired
    private PersonnelsRepository personnelsRepository;


    public PatientImpl(PatientRepository patientRepository, DossierRepository dossierMedicalRepository, PersonnelsRepository personnelsRepository) {
        this.patientRepository = patientRepository;
        this.dossierMedicalRepository = dossierMedicalRepository;
        this.personnelsRepository = personnelsRepository;
    }

    @Override
    public Patient creerPatients(PatientDTO patientDTO) {
        Patient patient = convertDTOToEntity(patientDTO);
        patientRepository.save(patient);
        return patient;
    }


    @Override
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consultation non trouvé avec l'ID : " + id));
        patientRepository.delete(patient);
        dossierMedicalRepository.delete(patient.getDossierMedical());
    }

    @Override
    public List<Patient> getPatients() {
       return patientRepository.findAll();
    }


    private Patient convertDTOToEntity(PatientDTO patientDTO){
        Patient patient = new Patient();

        patient.setNom(patientDTO.getNom());
        patient.setPrenom(patientDTO.getPrenom());
        patient.setSexe(patientDTO.getSexe());
        patient.setLieuNaissance(patientDTO.getLieuNaissance());
        patient.setDateNaissance(patientDTO.getDateNaissance());
        patient.setAdresse(patientDTO.getAdresse());
        patient.setEmail(patientDTO.getEmail());
        patient.setTelephone(patientDTO.getTelephone());
        patient.setProfession(patientDTO.getProfession());
        patient.setGroupe_sanguin((patient.getGroupe_sanguin()));

        if (patientDTO.getPersonnel_id() != null) {
            Personnels personnels = personnelsRepository.findById(patientDTO.getPersonnel_id())
                    .orElseThrow(() -> new EntityNotFoundException("l'ID non trouvé : " + patientDTO.getPersonnel_id()));
            patient.setPersonnel_id(personnels);
        }
        else{
            patient.setPersonnel_id(null);
        }

        if (patientDTO.getDossierMedicalId() != null) {
            DossierMedical dossierMedical1 = dossierMedicalRepository.findById(patientDTO.getDossierMedicalId())
                    .orElseThrow(() -> new EntityNotFoundException("DossierMedical non trouvé avec l'ID : " + patientDTO.getDossierMedicalId()));
            patient.setDossierMedical(dossierMedical1);
        } else {

        }
        return patient;
    }

    @Override
    public Patient obtenirPatientParId(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient non trouvé avec l'ID : " + id));
        return  patient;
    }

    @Override
    public Patient updatePatient(Long id, PatientDTO patientDTO) {
        // Buscar el paciente por su ID
        Patient existingPatient = patientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Patient non trouvé avec l'ID : " + id));

        // Actualizar los campos del paciente con los datos de DTO
        existingPatient.setNom(patientDTO.getNom());
        existingPatient.setPrenom(patientDTO.getPrenom());
        existingPatient.setSexe(patientDTO.getSexe());
        existingPatient.setLieuNaissance(patientDTO.getLieuNaissance());
        existingPatient.setDateNaissance(patientDTO.getDateNaissance());
        existingPatient.setAdresse(patientDTO.getAdresse());
        existingPatient.setEmail(patientDTO.getEmail());
        existingPatient.setTelephone(patientDTO.getTelephone());

        // Si el DTO proporciona un ID de DossierMedical, actualiza el DossierMedical asociado.
        if (patientDTO.getDossierMedicalId() != null) {
            DossierMedical dossierMedical = dossierMedicalRepository.findById(patientDTO.getDossierMedicalId())
                    .orElseThrow(() -> new EntityNotFoundException("DossierMedical non trouvé avec l'ID : " + patientDTO.getDossierMedicalId()));
            existingPatient.setDossierMedical(dossierMedical);
        }

        // Guardar el paciente actualizado en la base de datos
        return patientRepository.save(existingPatient);
    }

}
