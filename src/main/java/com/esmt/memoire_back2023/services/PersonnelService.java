package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.AdminDTO;
import com.esmt.memoire_back2023.dto.PersonnelsDTO;
import com.esmt.memoire_back2023.entity.Admin;
import com.esmt.memoire_back2023.entity.Personnels;
import com.esmt.memoire_back2023.entity.UserRole;

import java.util.List;

public interface PersonnelService {
    Personnels creerPersonnels(PersonnelsDTO personnelsDTO);

    void deletePersonnel(Long id);

    List<Personnels> trierParRole(UserRole role);

    Personnels updatePersonnels(Long id, PersonnelsDTO personnelsDTO);
}
