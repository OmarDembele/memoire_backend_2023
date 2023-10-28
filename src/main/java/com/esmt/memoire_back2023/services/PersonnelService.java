package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.PersonnelsDTO;
import com.esmt.memoire_back2023.entity.Personnels;

import java.util.List;

public interface PersonnelService {
    Personnels creerPersonnels(PersonnelsDTO personnelsDTO);

    List<PersonnelsDTO> getallPersonnels();

    PersonnelsDTO getPersonnelById(Long id);

}
