package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.HospitalisationDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.entity.Hospitalisation;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.repository.DossierRepository;
import com.esmt.memoire_back2023.repository.HospitalisationRepository;
import com.esmt.memoire_back2023.services.HospitalisationService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

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
    public Hospitalisation updateHospi(Long id, HospitalisationDTO hospitalisationDTO) {
        Optional<Hospitalisation> optionalHospitalisation = hospitalisationRepository.findById(id);

        Hospitalisation existingHospi = optionalHospitalisation.get();

        existingHospi.setLit(hospitalisationDTO.getLit());
        existingHospi.setType(hospitalisationDTO.getType());
        existingHospi.setLieu(hospitalisationDTO.getLieu());
        existingHospi.setDatesortie(hospitalisationDTO.getDatesortie());
        existingHospi.setDatehospitalisation(hospitalisationDTO.getDatehospitalisation());
        //dossierMedicalRepository.save()
        return hospitalisationRepository.save(existingHospi);
    }

    @Override
    public Hospitalisation getHospitalisationById(Long id) {
        Hospitalisation hospitalisation = hospitalisationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Hospitalisation non trouvé avec l'ID : " + id));

        return hospitalisation;
    }

    @Override
    public List<Hospitalisation> getHospitalisationsByDossierMedical(Long dossierMedicalId) {
        return hospitalisationRepository.findByDossierMedicalId(dossierMedicalId);
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
