package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.HospitalisationDTO;
import com.esmt.memoire_back2023.entity.Consultation;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Hospitalisation;
import com.esmt.memoire_back2023.repository.HospitalisationRepository;
import com.esmt.memoire_back2023.services.HospitalisationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalisationImpl implements HospitalisationService {

    @Autowired
    private HospitalisationRepository hospitalisationRepository;


    @Override
    public Hospitalisation creerHospi(HospitalisationDTO hospitalisationDTO) {
        Hospitalisation hospitalisation = convertDTOToEntity(hospitalisationDTO);
        hospitalisationRepository.save(hospitalisation);
        return hospitalisation;
    }

    @Override
    public void deleteHospi(Long id) {
        Hospitalisation hospitalisation = hospitalisationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Id inexistant : " + id));
        hospitalisationRepository.delete(hospitalisation);
    }

    private Hospitalisation convertDTOToEntity(HospitalisationDTO hospitalisationDTO){
        Hospitalisation hospitalisation = new Hospitalisation();

        hospitalisation.setLieu(hospitalisationDTO.getLieu());
        hospitalisation.setDatehospitalisation(hospitalisationDTO.getDatehospitalisation());
        hospitalisation.setDatesortie(hospitalisationDTO.getDatesortie());
        hospitalisation.setType(hospitalisationDTO.getType());
        hospitalisation.setLit(hospitalisationDTO.getLit());

        if (hospitalisationDTO.getDossierMedical_id() != null) {
            Hospitalisation hospitalisation1 = hospitalisationRepository.findById(hospitalisationDTO.getDossierMedical_id())
                    .orElseThrow(() -> new EntityNotFoundException("DossierMedical non trouvé avec l'ID : " + hospitalisationDTO.getDossierMedical_id()));
            hospitalisation.setDossierMedical_id(hospitalisation1.getDossierMedical_id());
        }
        return hospitalisation;
    }
}
