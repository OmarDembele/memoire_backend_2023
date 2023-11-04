package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.NextRvDTO;
import com.esmt.memoire_back2023.entity.NextRv;
import com.esmt.memoire_back2023.entity.Patient;

import java.util.List;

public interface NextRvService {

    NextRv addRv(NextRvDTO nextRvDTO);

    void deleteNextRV(Long id);

    List<NextRv> getAllRv(Long id);
}
