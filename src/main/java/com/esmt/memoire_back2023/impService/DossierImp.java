package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.DossierDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.services.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DossierImp implements DossierService {

    @Autowired
    private DossierRepository dossierRepository;

    public DossierImp(DossierRepository dossierRepository) {
        this.dossierRepository = dossierRepository;
    }

    @Override
    public DossierMedical creerDossier(DossierDTO dossierDTO) {
        DossierMedical dossierMedical = convertDTOToEntity(dossierDTO);
        dossierRepository.save(dossierMedical);
        return dossierMedical;
    }

    private DossierMedical convertDTOToEntity(DossierDTO dossierDTO){
        DossierMedical dossierMedical = new DossierMedical();
        dossierMedical.setNumero_dossier(dossierDTO.getNumero_dossier());
        dossierMedical.setDateCreation(dossierDTO.getDateCreation());
        dossierMedical.setDescription(dossierDTO.getDescription());

        return  dossierMedical;
    }

    @Override
    public List<DossierDTO> obtenirTousLesDossiers() {
        List<DossierMedical> dossiersMedicaux = dossierRepository.findAll();

        // Convertir les entités en DTO
        List<DossierDTO> dossierDTOs = dossiersMedicaux.stream()
                .map(dossierMedical -> new DossierDTO(
                        dossierMedical.getIdDossier(),
                        dossierMedical.getNumero_dossier(),
                        dossierMedical.getDateCreation(),
                        dossierMedical.getDescription()
                ))
                .collect(Collectors.toList());

        return dossierDTOs;
    }

    @Override
    public Optional<DossierMedical> getDossierById(Long id) {
        Optional<DossierMedical> dossierMedical = dossierRepository.findById(id);
        return dossierMedical;
    }
}
