package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.PersonnelsDTO;
import com.esmt.memoire_back2023.dto.PrendreRvDTO;
import com.esmt.memoire_back2023.entity.Consultation;
import com.esmt.memoire_back2023.entity.PrendreRv;
import com.esmt.memoire_back2023.repository.PrendreRvRepository;
import com.esmt.memoire_back2023.services.PrendreRvService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public void deletePrendreRvService(Long id) {
        PrendreRv prendreRv = prendreRvRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'id n'existe pas : " + id));
        prendreRvRepository.delete(prendreRv);
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

    public List<PrendreRvDTO> getallPrendreRv() {
        List<PrendreRv> prendreRv = prendreRvRepository.findAll();

        // Convertir la liste des entités en liste de DTOs
        List<PrendreRvDTO> prendreRvDTOS = prendreRv.stream()
                .map(prendreRvs -> new PrendreRvDTO(
                        prendreRvs.getId(),
                        prendreRvs.getNom(),
                        prendreRvs.getPrenom(),
                        prendreRvs.getSexe(),
                        prendreRvs.getDateNaissance(),
                        prendreRvs.getLieuNaissance(),
                        prendreRvs.getTelephone(),
                        prendreRvs.getEmail(),
                        prendreRvs.getAdresse(),
                        prendreRvs.getProfession(),
                        prendreRvs.getHeureRv(),
                        prendreRvs.getDateRv()
                ))
                .collect(Collectors.toList()); // Ajout de collect() pour terminer la conversion et obtenir une liste

        return prendreRvDTOS;
    }

    @Override
    public PrendreRvDTO getPrendreRvById(Long id) {
        PrendreRv prendreRv = prendreRvRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Rendez-vous non trouvé avec l'ID : " + id));

        return new PrendreRvDTO(
                prendreRv.getId(),
                prendreRv.getNom(),
                prendreRv.getPrenom(),
                prendreRv.getSexe(),
                prendreRv.getDateNaissance(),
                prendreRv.getLieuNaissance(),
                prendreRv.getTelephone(),
                prendreRv.getEmail(),
                prendreRv.getAdresse(),
                prendreRv.getProfession(),
                prendreRv.getHeureRv(),
                prendreRv.getDateRv()
        );
    }


}
