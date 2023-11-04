package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.HospitalisationDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Hospitalisation;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.repository.HospitalisationRepository;
import com.esmt.memoire_back2023.services.HospitalisationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HospitalisationImpl implements HospitalisationService {

    @Autowired
    private HospitalisationRepository hospitalisationRepository;

    @Autowired
    private DossierRepository dossierRepository;

    public HospitalisationImpl(HospitalisationRepository hospitalisationRepository, DossierRepository dossierRepository) {
        this.hospitalisationRepository = hospitalisationRepository;
        this.dossierRepository = dossierRepository;
    }


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

    @Override
    public List<Hospitalisation> getAllHospi() {
        return hospitalisationRepository.findAll();
    }

    @Override
    public HospitalisationDTO getHospitalisationById(Long id) {
        Hospitalisation hospitalisation = hospitalisationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospitalisation non trouvé avec l'ID : " + id));

        return new HospitalisationDTO(
                hospitalisation.getId(),
                hospitalisation.getLieu(),
                hospitalisation.getDatehospitalisation(),
                hospitalisation.getDatesortie(),
                hospitalisation.getType(),
                hospitalisation.getLit(),
                hospitalisation.getDossierMedical_id()
        );
    }


    private Hospitalisation convertDTOToEntity(HospitalisationDTO hospitalisationDTO){
        Hospitalisation hospitalisation = new Hospitalisation();

        hospitalisation.setLieu(hospitalisationDTO.getLieu());
        hospitalisation.setDatehospitalisation(hospitalisationDTO.getDatehospitalisation());
        hospitalisation.setDatesortie(hospitalisationDTO.getDatesortie());
        hospitalisation.setType(hospitalisationDTO.getType());
        hospitalisation.setLit(hospitalisationDTO.getLit());
        hospitalisation.setDossierMedical_id(hospitalisationDTO.getDossierMedical_id());
        return hospitalisation;
    }
}
