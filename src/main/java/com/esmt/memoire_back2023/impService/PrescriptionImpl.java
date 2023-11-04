package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.PrescriptionDTO;
import com.esmt.memoire_back2023.entity.Hospitalisation;
import com.esmt.memoire_back2023.entity.PrendreRv;
import com.esmt.memoire_back2023.entity.Prescription;
import com.esmt.memoire_back2023.repository.PrescriptionRepository;
import com.esmt.memoire_back2023.services.PrescriptionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrescriptionImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;


    @Override
    public Prescription creerPresc(PrescriptionDTO prescriptionDTO) {
        Prescription prescription = convertDTOToEntity(prescriptionDTO);
        prescriptionRepository.save(prescription);
        return prescription;
    }

    @Override
    public void delletePresc(Long id) {
        Prescription prescription = prescriptionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'id n'existe pas : " + id));
        prescriptionRepository.delete(prescription);
    }

    private Prescription convertDTOToEntity(PrescriptionDTO prescriptionDTO){
        Prescription prescription = new Prescription();

        prescription.setInstruction(prescriptionDTO.getInstruction());
        prescription.setType(prescriptionDTO.getType());
        prescription.setDossierMedical_id(prescriptionDTO.getDossierMedical_id());

        return prescription;

    }
}
