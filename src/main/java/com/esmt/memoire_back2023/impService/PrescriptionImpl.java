package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.PrescriptionDTO;
import com.esmt.memoire_back2023.entity.Hospitalisation;
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

    private Prescription convertDTOToEntity(PrescriptionDTO prescriptionDTO){
        Prescription prescription = new Prescription();

        prescription.setInstruction(prescriptionDTO.getInstruction());
        prescription.setType(prescriptionDTO.getType());
        if (prescriptionDTO.getDossierMedical_id() != null) {
            Prescription prescription1 = prescriptionRepository.findById(prescriptionDTO.getDossierMedical_id())
                    .orElseThrow(() -> new EntityNotFoundException("DossierMedical non trouvé avec l'ID : " + prescriptionDTO.getDossierMedical_id()));
            prescription.setDossierMedical_id(prescription1.getDossierMedical_id());
        }

        return prescription;

    }
}
