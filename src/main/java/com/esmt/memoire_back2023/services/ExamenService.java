package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.ExamenDTO;
import com.esmt.memoire_back2023.entity.ExamenMedical;

public interface ExamenService {

    ExamenMedical creerExamen(ExamenDTO examenDTO);

    ExamenDTO getExamenMedicalById(Long id);

    void delleteExam(Long id);



}
