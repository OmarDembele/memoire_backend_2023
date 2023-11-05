package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.SoinsDTO;
import com.esmt.memoire_back2023.entity.Soins;

import java.util.List;

public interface SoinsService {

    Soins creerSoins (SoinsDTO soinsDTO);

    List<Soins> getAllSoinsByPersonnelId(Long personnel_id);

    void deleteSoins(Long id);

}
