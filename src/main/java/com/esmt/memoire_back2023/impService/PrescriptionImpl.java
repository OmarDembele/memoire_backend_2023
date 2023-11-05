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

import java.util.List;

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

    @Override
    public List<Prescription> getPrescByPersonnelId(Long personnelId) {
        return prescriptionRepository.findByPersonnel(personnelId);
    }

    private Prescription convertDTOToEntity(PrescriptionDTO prescriptionDTO){
        Prescription prescription = new Prescription();

        prescription.setInstruction(prescriptionDTO.getInstruction());
        prescription.setType(prescriptionDTO.getType());
        prescription.setDossier_medicalId(prescriptionDTO.getDossier_medicalId());
        prescription.setPersonnel(prescriptionDTO.getPersonnel());

        return prescription;

    }
}
