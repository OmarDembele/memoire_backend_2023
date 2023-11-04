package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.ConsultationDTO;
import com.esmt.memoire_back2023.entity.*;
import com.esmt.memoire_back2023.repository.ConsultationRepository;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.repository.PersonnelsRepository;
import com.esmt.memoire_back2023.services.ConsultationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsultationImpl implements ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private DossierRepository dossierRepository;

    @Autowired
    private PersonnelsRepository personnelsRepository;

    public ConsultationImpl(ConsultationRepository consultationRepository, DossierRepository dossierRepository) {
        this.consultationRepository = consultationRepository;
        this.dossierRepository = dossierRepository;
    }

    @Override
    public Consultation addConsultation(ConsultationDTO consultationDTO) {
        Consultation consultation = convertDTOToEntity(consultationDTO);
        consultationRepository.save(consultation);
        return consultation;
    }

    @Override
    public List<Consultation> getAllConsultations() {
        return consultationRepository.findAll();
    }

    @Override
    public Consultation getConsultationById(Long id) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("L'ID non trouvé : " + id));
        return consultation;
    }


    @Override
    public void deleteConsultation(Long id) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consultation non trouvée avec l'ID : " + id));
        consultationRepository.delete(consultation);
    }

    @Override
    public List<Consultation> getConsultationsByDossierMedical(Long dossierMedicalId) {
        return consultationRepository.findByDossierMedicalId(dossierMedicalId);
    }

    public Consultation convertDTOToEntity(ConsultationDTO consultationDTO) {
        Consultation consultation = new Consultation();
        consultation.setMedecinConsultant(consultationDTO.getMedecinConsultant());
        consultation.setMedecinTraitant(consultationDTO.getMedecinTraitant());
        consultation.setMedecinChirurgien(consultationDTO.getMedecinChirurgien());
        consultation.setTaille(consultationDTO.getTaille());
        consultation.setPoids(consultationDTO.getPoids());
        consultation.setNameurgence(consultationDTO.getNameurgence());
        consultation.setAdresse(consultationDTO.getAdresse());
        consultation.setTelephone(consultationDTO.getTelephone());
        consultation.setDiagnostic(consultationDTO.getDiagnostic());
        consultation.setDescription(consultationDTO.getDescription());
        consultation.setAntecedent(consultationDTO.getAntecedent());
        consultation.setAncientraitement(consultationDTO.getAncientraitement());
        consultation.setDateconsultation(consultationDTO.getDateconsultation());
        consultation.setDossierMedical_id(consultationDTO.getDossierMedical_id());

        return consultation;
    }
}
