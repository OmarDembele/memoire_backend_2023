package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.NextRvDTO;
import com.esmt.memoire_back2023.entity.NextRv;

public interface NextRvService {

    NextRv addRv(NextRvDTO nextRvDTO);
}