package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.ExamenDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.ExamenMedical;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.repository.ExamenRepository;
import com.esmt.memoire_back2023.services.ExamenService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamenImpl implements ExamenService {

    @Autowired
    private ExamenRepository examenRepository;

    @Autowired
    private DossierRepository dossierRepository;

    @Override
    public ExamenMedical creerExamen(ExamenDTO examenDTO) {
        ExamenMedical examenMedical1 = convertDTOToEntity(examenDTO);
        examenRepository.save(examenMedical1);
        return examenMedical1;
    }
    @Override
    public ExamenMedical getExamenMedicalById(Long id) {
        ExamenMedical examenMedical = examenRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Examen médical non trouvé avec l'ID : " + id));

        return examenMedical;
    }
    @Override
    public void delleteExam(Long id) {
        ExamenMedical examenMedical = examenRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id inexistant : " + id));
        examenRepository.delete(examenMedical);
    }


    private ExamenMedical convertDTOToEntity(ExamenDTO examenDTO){
        ExamenMedical examenMedical = new ExamenMedical();

        examenMedical.setType(examenDTO.getType());
        examenMedical.setResultat(examenDTO.getResultat());

        if (examenDTO.getDossierMedical_id() != null) {
            DossierMedical examenMedical1 = dossierRepository.findById(examenDTO.getDossierMedical_id())
                    .orElseThrow(() -> new EntityNotFoundException("DossierMedical non trouvé avec l'ID : " + examenDTO.getDossierMedical_id()));
            examenMedical.setDossierMedical_id(examenMedical1);
        }
        return examenMedical;
    }

}
