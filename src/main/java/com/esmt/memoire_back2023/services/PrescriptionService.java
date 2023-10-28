package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.PrescriptionDTO;
import com.esmt.memoire_back2023.entity.Prescription;

public interface PrescriptionService {

    Prescription creerPresc(PrescriptionDTO prescriptionDTO);
}
