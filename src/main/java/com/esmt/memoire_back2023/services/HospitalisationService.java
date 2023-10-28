package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.HospitalisationDTO;
import com.esmt.memoire_back2023.entity.Hospitalisation;

public interface HospitalisationService {

    Hospitalisation creerHospi(HospitalisationDTO hospitalisationDTO);
}
