package com.esmt.memoire_back2023.services;


import com.esmt.memoire_back2023.dto.DossierDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;

import java.util.List;
import java.util.Optional;

public interface DossierService {
    DossierMedical creerDossier(DossierDTO dossierDTO);

    List<DossierDTO> obtenirTousLesDossiers();

    Optional<DossierMedical> getDossierById(Long id);
}

