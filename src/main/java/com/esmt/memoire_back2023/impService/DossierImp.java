package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.DossierDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.repository.PatientRepository;
import com.esmt.memoire_back2023.services.DossierService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DossierImp implements DossierService {

    @Autowired
    private DossierRepository dossierRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public DossierMedical creerDossier(DossierDTO dossierDTO) {
        DossierMedical dossierMedical = convertDTOToEntity(dossierDTO);
        dossierRepository.save(dossierMedical);
        return null;
    }

    private DossierMedical convertDTOToEntity(DossierDTO dossierDTO){
        DossierMedical dossierMedical = new DossierMedical();
        dossierMedical.setDateCreation(dossierDTO.getDateCreation());
        dossierMedical.setDescription(dossierDTO.getDescription());

        if (dossierDTO.getPatientId() != null) {
            Patient patient = patientRepository.findById(dossierDTO.getPatientId())
                    .orElseThrow(() -> new EntityNotFoundException("DossierMedical non trouvé avec l'ID : " + dossierDTO.getPatientId()));
            dossierMedical.setPatient(patient);
        }
        return  dossierMedical;
    }
}
