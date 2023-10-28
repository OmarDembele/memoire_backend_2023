package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.ConsultationDTO;
import com.esmt.memoire_back2023.entity.Consultation;

public interface ConsultationService {
    Consultation addConsultation(ConsultationDTO consultationDTO);
}
