package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.SoinsDTO;
import com.esmt.memoire_back2023.entity.Prescription;
import com.esmt.memoire_back2023.entity.Soins;
import com.esmt.memoire_back2023.repository.SoinsRepository;
import com.esmt.memoire_back2023.services.SoinsService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoinsImpl implements SoinsService {

    @Autowired
    private SoinsRepository soinsRepository;

    public SoinsImpl(SoinsRepository soinsRepository) {
        this.soinsRepository = soinsRepository;
    }

    @Override
    public Soins creerSoins(SoinsDTO soinsDTO) {
        Soins soins = convertDTOToEntity(soinsDTO);
        soinsRepository.save(soins);
        return soins;
    }

    @Override
    public List<Soins> getAllSoinsByPersonnelId(Long personnel_id) {
        return soinsRepository.findSoinsByPersonnelId(personnel_id);
    }

    @Override
    public void deleteSoins(Long id) {
        Soins soins = soinsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'id n'existe pas : " + id));
        soinsRepository.delete(soins);
    }

    private Soins convertDTOToEntity(SoinsDTO soinsDTO){
        Soins soins = new Soins();

        soins.setDate(soinsDTO.getDate());
        soins.setTraitement(soinsDTO.getTraitement());
        soins.setDossier_medical_id(soinsDTO.getDossier_medical_id());
        soins.setPersonnel_id(soinsDTO.getPersonnel_id());

        return soins;
    }
}
