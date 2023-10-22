package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.DossierDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;

public interface DossierService {
    DossierMedical creerDossier(DossierDTO dossierDTO);
}

