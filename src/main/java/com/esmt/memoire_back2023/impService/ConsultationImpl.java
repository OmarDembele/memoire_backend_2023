package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.ConsultationDTO;
import com.esmt.memoire_back2023.entity.Consultation;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.entity.Personnels;
import com.esmt.memoire_back2023.repository.ConsultationRepository;
import com.esmt.memoire_back2023.services.ConsultationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultationImpl implements ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public Consultation addConsultation(ConsultationDTO consultationDTO) {
        Consultation consultation = convertDTOToEntity(consultationDTO);
        consultationRepository.save(consultation);
        return consultation;
    }

    @Override
    public List<ConsultationDTO> getAllConsultations() {
        List<Consultation> consultations = consultationRepository.findAll();

        return consultations.stream()
                .map(consultation -> new ConsultationDTO(
                        consultation.getIdConsultation(),
                        consultation.getMedecinTraitant().getIdPersonnel(),
                        consultation.getMedecinConsultant().getIdPersonnel(),
                        consultation.getMedecinChirurgien().getIdPersonnel(),
                        consultation.getAntecedent(),
                        consultation.getAncientraitement(),
                        consultation.getPatients().stream().findFirst().get().getIdPatient(),
                        consultation.getAntecedent(),
                        consultation.getAncientraitement(),
                        consultation.getDateconsultation(),
                        consultation.getDiagnostic(),
                        consultation.getDescription()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public ConsultationDTO getConsultationById(Long id) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consultation non trouvée avec l'ID : " + id));

        return new ConsultationDTO(
                consultation.getIdConsultation(),
                consultation.getMedecinTraitant().getIdPersonnel(),
                consultation.getMedecinConsultant().getIdPersonnel(),
                consultation.getMedecinChirurgien().getIdPersonnel(),
                consultation.getAntecedent(),
                consultation.getAncientraitement(),
                consultation.getPatients().stream().findFirst().get().getIdPatient(),
                consultation.getAntecedent(),
                consultation.getAncientraitement(),
                consultation.getDateconsultation(),
                consultation.getDiagnostic(),
                consultation.getDescription()
        );
    }



    @Override
    public void deleteConsultation(Long id) {
        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Consultation non trouvée avec l'ID : " + id));
        consultationRepository.delete(consultation);
    }

    public Consultation convertDTOToEntity(ConsultationDTO consultationDTO) {
        Consultation consultation = new Consultation();

        consultation.setPatients(new HashSet<>());
        consultation.getPatients().add(new Patient(consultationDTO.getPatientId()));

        consultation.setMedecinTraitant(new Personnels(consultationDTO.getMedecinTraitantId()));
        consultation.setMedecinConsultant(new Personnels(consultationDTO.getMedecinConsultantId()));
        consultation.setMedecinChirurgien(new Personnels(consultationDTO.getMedecinChirurgienId()));
        consultation.setDiagnostic(consultationDTO.getDiagnostic());
        consultation.setDescription(consultationDTO.getDescription());
        consultation.setAntecedent(consultationDTO.getAntecedent());
        consultation.setAncientraitement(consultationDTO.getAncientraitement());
        consultation.setDateconsultation(consultationDTO.getDateconsultation());
        return consultation;
    }
}
