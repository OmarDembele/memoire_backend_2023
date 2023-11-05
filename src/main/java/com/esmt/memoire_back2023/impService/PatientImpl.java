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
import java.util.Optional;

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

    @Override
    public List<Patient> getPatientByPersonnel(Long personnelId) {
        return patientRepository.findByPersonnelId(personnelId);
    }

    @Override
    public List<Patient> getPatientsByDossierMedical(DossierMedical dossierMedicalId) {
        return patientRepository.findByDossierMedical(dossierMedicalId);
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
        patient.setGroupe_sanguin((patientDTO.getGroupe_sanguin()));
        patient.setPersonnel_id(patientDTO.getPersonnel_id());

        if (patientDTO.getDossierMedicalId() != null) {
            DossierMedical dossierMedical1 = dossierMedicalRepository.findById(patientDTO.getDossierMedicalId())
                    .orElseThrow(() -> new EntityNotFoundException("DossierMedical non trouvé avec l'ID : " + patientDTO.getDossierMedicalId()));
            patient.setDossierMedical(dossierMedical1);
        } else {
            patient.setDossierMedical(patientDTO.getDossierMedical());
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
        Optional<Patient> optionalPatient = patientRepository.findById(id);

        Patient existingPatient = optionalPatient.get();

        existingPatient.setNom(patientDTO.getNom());
        existingPatient.setPrenom(patientDTO.getPrenom());
        existingPatient.setSexe(patientDTO.getSexe());
        existingPatient.setLieuNaissance(patientDTO.getLieuNaissance());
        existingPatient.setDateNaissance(patientDTO.getDateNaissance());
        existingPatient.setAdresse(patientDTO.getAdresse());
        existingPatient.setEmail(patientDTO.getEmail());
        existingPatient.setTelephone(patientDTO.getTelephone());
        existingPatient.setProfession(patientDTO.getProfession());
        existingPatient.setGroupe_sanguin((patientDTO.getGroupe_sanguin()));
        existingPatient.setPersonnel_id(patientDTO.getPersonnel_id());
        //dossierMedicalRepository.save()
        return patientRepository.save(existingPatient);
    }

}