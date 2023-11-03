package com.esmt.memoire_back2023.impService;


import com.esmt.memoire_back2023.dto.ConsultationDTO;
import com.esmt.memoire_back2023.entity.*;
import com.esmt.memoire_back2023.repository.ConsultationRepository;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.services.ConsultationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ConsultationImpl implements ConsultationService {


    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private DossierRepository dossierRepository;


    @Override
    public Consultation addConsultation(ConsultationDTO consultationDTO) {
        Consultation consultation = convertDTOToEntity(consultationDTO);
        consultationRepository.save(consultation);
        return consultation;
    }

    @Override
    public void deleteConsultation(Long id) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consultation non trouvé avec l'ID : " + id));
        consultationRepository.delete(consultation);
    }

    public Consultation convertDTOToEntity(ConsultationDTO consultationDTO) {
        Consultation consultation = new Consultation();

        consultation.setPatients(new HashSet<>());
        consultation.getPatients().add(new Patient(consultationDTO.getPatientId()));

        consultation.setMedecinTraitant(new Personnels(consultationDTO.getMedecinTraitantId()));
        consultation.setMedecinConsultant(new Personnels(consultationDTO.getMedecinConsultantId()));
        consultation.setMedecinChirurgien(new Personnels(consultationDTO.getMedecinChirurgienId()));
        consultation.setTaille(consultationDTO.getTaille());
        consultation.setPoids(consultationDTO.getPoids());
        consultation.setNameurgence(consultationDTO.getNameurgence());
        consultation.setAdresse(consultationDTO.getAdresse());
        consultation.setTelephone(consultationDTO.getTelephone());
        consultation.setDiagnostic(consultationDTO.getDiagnostic());
        consultation.setDescription(consultationDTO.getDescription());
        consultation.setAntecedent(consultationDTO.getAntecedent());
        consultation.setAncientraitement(consultationDTO.getAncientraitement());
        consultation.setDateconsultation(consultationDTO.getDateconsultation());

        if (consultationDTO.getDossierMedical_id() != null) {
            DossierMedical dossierMedical = dossierRepository.findById(consultationDTO.getDossierMedical_id())
                    .orElseThrow(() -> new EntityNotFoundException("DossierMedical non trouvé avec l'ID : " + consultationDTO.getDossierMedical_id()));
            consultation.setDossierMedical_id(dossierMedical);
        }
        return consultation;
    }

}

/*
public Consultation convertDTOToEntity(ConsultationDTO consultationDTO) {
        Consultation consultation = new Consultation();

        consultation.setPatients(new HashSet<>());
        consultation.getPatients().add(new Patient(consultationDTO.getPatientId()));

        if(consultationDTO.getMedecinConsultantId() != null){
            Personnels medecin_consultant = personnelsRepository.findById(consultationDTO.getMedecinConsultantId())
                    .orElseThrow(() -> new EntityNotFoundException("l'ID du medecin constant n'existe pas : " + consultationDTO.getMedecinConsultantId()));
            consultation.setMedecinConsultant(medecin_consultant);
        }

        if(consultationDTO.getMedecinTraitantId() != null){
            Personnels medecin_traitant = personnelsRepository.findById(consultationDTO.getMedecinTraitantId())
                    .orElseThrow(() -> new EntityNotFoundException("l'ID du medecin traitant n'existe pas : " + consultationDTO.getMedecinTraitantId()));
            consultation.setMedecinTraitant(medecin_traitant);
        }
        if(consultationDTO.getMedecinChirurgienId() != null){
            Personnels medecin_churigien = personnelsRepository.findById(consultationDTO.getMedecinChirurgienId())
                    .orElseThrow(() -> new EntityNotFoundException("l'ID du medecin churiggien n'existe pas : " + consultationDTO.getMedecinChirurgienId()));
            consultation.setMedecinChirurgien(medecin_churigien);
        }

        consultation.setTaille(consultationDTO.getTaille());
        consultation.setPoids(consultationDTO.getPoids());
        consultation.setNameurgence(consultationDTO.getNameurgence());
        consultation.setAdresse(consultationDTO.getAdresse());
        consultation.setTelephone(consultationDTO.getTelephone());
        consultation.setDiagnostic(consultationDTO.getDiagnostic());
        consultation.setDescription(consultationDTO.getDescription());
        consultation.setAntecedent(consultationDTO.getAntecedent());
        consultation.setAncientraitement(consultationDTO.getAncientraitement());
        consultation.setDateconsultation(consultationDTO.getDateconsultation());

        if (consultationDTO.getDossierMedical_id() != null) {
            DossierMedical dossierMedical = dossierRepository.findById(consultationDTO.getDossierMedical_id())
                    .orElseThrow(() -> new EntityNotFoundException("DossierMedical non trouvé avec l'ID : " + consultationDTO.getDossierMedical_id()));
            consultation.setDossierMedical_id(dossierMedical);
        }
        return consultation;
    }
 */
