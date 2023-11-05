package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.ExamenDTO;
import com.esmt.memoire_back2023.entity.ExamenMedical;

import java.util.List;

public interface ExamenService {

    ExamenMedical creerExamen(ExamenDTO examenDTO);

    ExamenMedical getExamenMedicalById(Long id);

    void delleteExam(Long id);

    List<ExamenMedical> findByPersonnel(Long personnelId);




}
