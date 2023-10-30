package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.ConsultationDTO;
import com.esmt.memoire_back2023.entity.Consultation;

import java.util.List;

public interface ConsultationService {
    Consultation addConsultation(ConsultationDTO consultationDTO);

    List<ConsultationDTO> getAllConsultations();

    ConsultationDTO getConsultationById(Long id);

    void deleteConsultation(Long id);


}
