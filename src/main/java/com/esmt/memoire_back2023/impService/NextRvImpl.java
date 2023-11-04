package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.NextRvDTO;
import com.esmt.memoire_back2023.entity.Consultation;
import com.esmt.memoire_back2023.entity.NextRv;
import com.esmt.memoire_back2023.repository.NextRvRepository;
import com.esmt.memoire_back2023.services.NextRvService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void deleteNextRV(Long id) {
        NextRv nextRv = nextRvRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID non trouvé : " + id));
        nextRvRepository.delete(nextRv);
    }

    @Override
    public List<NextRv> getAllRv(Long id) {
        return nextRvRepository.findByPersonnel(id);
    }

    private NextRv convertDtoToEntity(NextRvDTO nextRvDTO){
        NextRv nextRv = new NextRv();

        nextRv.setDossierid(nextRvDTO.getDossierid());
        nextRv.setMedecinassigne(nextRvDTO.getMedecinassigne());
        nextRv.setDaterv(nextRvDTO.getDaterv());
        nextRv.setHeurerv(nextRvDTO.getHeurerv());
        nextRv.setPersonnel(nextRvDTO.getPersonnel());
        return nextRv;
    }
}
