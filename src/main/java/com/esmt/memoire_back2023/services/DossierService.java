package com.esmt.memoire_back2023.services;


import com.esmt.memoire_back2023.dto.DossierDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;

import java.util.List;

public interface DossierService {
    DossierMedical creerDossier(DossierDTO dossierDTO);

    List<DossierDTO> obtenirTousLesDossiers();

    DossierMedical updateDossierMedical(Long id, DossierDTO dossierDTO);

    void deleteDossier(Long id);

    DossierDTO  getDossierMedicalById(Long id);



}

