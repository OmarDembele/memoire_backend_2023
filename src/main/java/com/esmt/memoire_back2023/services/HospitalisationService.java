package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.HospitalisationDTO;
import com.esmt.memoire_back2023.entity.Hospitalisation;
import com.esmt.memoire_back2023.entity.Patient;

import java.util.List;

public interface HospitalisationService {

    Hospitalisation creerHospi(HospitalisationDTO hospitalisationDTO);

    void deleteHospi(Long id);

    List<Hospitalisation> getAllHospi();
}
