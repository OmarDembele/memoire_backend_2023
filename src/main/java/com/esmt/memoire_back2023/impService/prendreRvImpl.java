package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.PrendreRvDTO;
import com.esmt.memoire_back2023.entity.PrendreRv;
import com.esmt.memoire_back2023.repository.PrendreRvRepository;
import com.esmt.memoire_back2023.services.PrendreRvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class prendreRvImpl implements PrendreRvService {

    @Autowired
    private PrendreRvRepository prendreRvRepository;

    public prendreRvImpl(PrendreRvRepository prendreRvRepository) {
        this.prendreRvRepository = prendreRvRepository;
    }


    @Override
    public PrendreRv prendreRv(PrendreRvDTO prendreRvDTO) {
        PrendreRv prendreRv = convertDTOToEntity(prendreRvDTO);
        prendreRvRepository.save(prendreRv);
        return prendreRv;
    }

    private PrendreRv convertDTOToEntity(PrendreRvDTO prendreRvDTO){
        PrendreRv prendreRv = new PrendreRv();
        prendreRv.setNom(prendreRvDTO.getNom());
        prendreRv.setPrenom(prendreRvDTO.getPrenom());
        prendreRv.setSexe(prendreRvDTO.getSexe());
        prendreRv.setLieuNaissance(prendreRvDTO.getLieuNaissance());
        prendreRv.setDateNaissance(prendreRvDTO.getDateNaissance());
        prendreRv.setAdresse(prendreRvDTO.getAdresse());
        prendreRv.setEmail(prendreRvDTO.getEmail());
        prendreRv.setTelephone(prendreRvDTO.getTelephone());
        prendreRv.setProfession(prendreRvDTO.getProfession());
        prendreRv.setHeureRv(prendreRvDTO.getHeureRv());
        prendreRv.setDateRv(prendreRvDTO.getDateRv());
        return  prendreRv;
    }
}
