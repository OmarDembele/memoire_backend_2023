package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.NextRvDTO;
import com.esmt.memoire_back2023.entity.NextRv;
import com.esmt.memoire_back2023.repository.NextRvRepository;
import com.esmt.memoire_back2023.services.NextRvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NextRvImpl implements NextRvService {

    @Autowired
    private NextRvRepository nextRvRepository;


    @Override
    public NextRv addRv(NextRvDTO nextRvDTO) {
        NextRv nextRv = convertDtoToEntity(nextRvDTO);
        nextRvRepository.save(nextRv);
        return nextRv;
    }

    private NextRv convertDtoToEntity(NextRvDTO nextRvDTO){
        NextRv nextRv = new NextRv();

        nextRv.setDossierid(nextRvDTO.getDossierid());
        nextRv.setMedecinassigne(nextRvDTO.getMedecinassigne());
        nextRv.setDaterv(nextRvDTO.getDaterv());
        nextRv.setHeurerv(nextRvDTO.getHeurerv());
        return nextRv;
    }
}
