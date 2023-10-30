package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.PrendreRvDTO;
import com.esmt.memoire_back2023.entity.PrendreRv;

import java.util.List;

public interface PrendreRvService {
    PrendreRv prendreRv(PrendreRvDTO prendreRvDTO);
    List<PrendreRvDTO> getallPrendreRv();

    PrendreRvDTO getPrendreRvById(Long id);

    void deletePrendreRvService(Long id);

}
