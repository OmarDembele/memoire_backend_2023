package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.PersonnelsDTO;
import com.esmt.memoire_back2023.entity.Personnels;

public interface PersonnelService {
    Personnels creerPersonnels(PersonnelsDTO personnelsDTO);
}
