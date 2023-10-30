package com.esmt.memoire_back2023.impService;


import com.esmt.memoire_back2023.dto.ConsultationDTO;
import com.esmt.memoire_back2023.entity.Consultation;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.entity.Personnels;
import com.esmt.memoire_back2023.repository.ConsultationRepository;
import com.esmt.memoire_back2023.services.ConsultationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class ConsultationImpl implements ConsultationService {


    @Autowired
    private ConsultationRepository consultationRepository;


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
        return consultation;
    }

}
