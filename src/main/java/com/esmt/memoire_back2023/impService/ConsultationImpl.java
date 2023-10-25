package com.esmt.memoire_back2023.impService;
/*
import com.esmt.memoire_back2023.dto.ConsultationDTO;
import com.esmt.memoire_back2023.entity.Consultation;
import com.esmt.memoire_back2023.repository.ConsultationRepository;
import com.esmt.memoire_back2023.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;

public class ConsultationImpl implements ConsultationService {


    @Autowired
    private ConsultationRepository consultationRepository;


    @Override
    public Consultation addConsultation(ConsultationDTO consultationDTO) {
        Consultation consultation = convertDTOToEntity(consultationDTO);
        consultationRepository.save(consultation);
        return consultation;
    }

    public ConsultationDTO convertDTOToEntity(ConsultationDTO consultationDTO) {
        Consultation consultation = new Consultation();
        consultation.setId(consultationDTO.getId());
        consultation.setPatient(consultationDTO.getPatientId().g);
        consultation.setMedecinTraitant(consultationDTO.getMedecinTraitantId());
        consultation.setMedecinConsultant(consultationDTO.getMedecinConsultantId());
        consultation.setMedecinChirurgien(consultationDTO.getMedecinChirurgienId());
        consultation.setAntecedentsMedicaux(consultationDTO.getAntecedentsMedicaux());
        consultation.setAnciensTraitements(consultationDTO.getAnciensTraitements());
        consultation.setDiagnostic(consultationDTO.getDiagnostic());
        consultation.setDescription(consultationDTO.getDescription());
        return consultation;
    }

}*/
