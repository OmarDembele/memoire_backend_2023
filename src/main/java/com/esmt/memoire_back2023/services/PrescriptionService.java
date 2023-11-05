package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.PrescriptionDTO;
import com.esmt.memoire_back2023.entity.Prescription;
import com.esmt.memoire_back2023.entity.Soins;

import java.util.List;

public interface PrescriptionService {

    Prescription creerPresc(PrescriptionDTO prescriptionDTO);

    void delletePresc(Long id);

    List<Prescription> getPrescByPersonnelId(Long personnelId);
}
