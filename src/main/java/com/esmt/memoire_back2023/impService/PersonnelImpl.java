package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.PersonnelsDTO;
import com.esmt.memoire_back2023.entity.Personnels;
import com.esmt.memoire_back2023.entity.UserRole;
import com.esmt.memoire_back2023.repository.PersonnelsRepository;
import com.esmt.memoire_back2023.services.PersonnelService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonnelImpl implements PersonnelService {

    @Autowired
    public PersonnelsRepository personnelsRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Override
    public Personnels creerPersonnels(PersonnelsDTO personnelsDTO) {
        Personnels personnels = convertDTOToEntity(personnelsDTO);
        personnelsRepository.save(personnels);
        return personnels;
    }



    private Personnels convertDTOToEntity(PersonnelsDTO personnelsDTO) {

        Personnels personnels = new Personnels();
        personnels.setNom(personnelsDTO.getNom());
        personnels.setPrenom(personnelsDTO.getPrenom());
        personnels.setSexe(personnelsDTO.getSexe());
        personnels.setDateNaissance(personnelsDTO.getDateNaissance());
        personnels.setLieuNaissance(personnelsDTO.getLieuNaissance());
        personnels.setEmail(personnelsDTO.getEmail());
        personnels.setAdresse(personnelsDTO.getAdresse());
        personnels.setTelephone(personnelsDTO.getTelephone());

        personnels.setNumLicence(personnelsDTO.getNumLicence());
        personnels.setSpecialite(personnelsDTO.getSpecialite());
        personnels.setRole(personnelsDTO.getRole());

        personnels.setLogin(personnelsDTO.getLogin());
        personnels.setPassword(this.passwordEncoder.encode(personnelsDTO.getPassword()));
        personnels.setDateInscription(personnelsDTO.getDateInscription());
        personnels.setEtat(personnelsDTO.getEtat());
        return personnels;

    }

    @Override
    public List<Personnels> getallPersonnels() {
        return personnelsRepository.findAll();
    }

    @Override
    public Optional<Personnels> getPersonnelById(Long id) {
        Optional<Personnels> personnel = personnelsRepository.findById(id);
        return personnel;
    }
    @Override
    public void deletePersonnel(Long id) {
        Personnels personnels = personnelsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin non trouvé avec l'ID : " + id));
        personnelsRepository.delete(personnels);
    }

    @Override
    public List<Personnels> trierParRole(UserRole role) {
        return personnelsRepository.findByRole(role);
    }

    @Override
    public Personnels updatePersonnels(Long id, PersonnelsDTO personnelsDTO) {
        Personnels personnelsToUpdate = convertDTOToEntity(personnelsDTO);

        Optional<Personnels> existingPersonnels = personnelsRepository.findById(id);
        if (!existingPersonnels.isPresent()) {
            return null;
        }
        Personnels updatedPersonnels = existingPersonnels.get();

        updatedPersonnels.setNom(personnelsDTO.getNom());
        updatedPersonnels.setPrenom(personnelsDTO.getPrenom());
        updatedPersonnels.setSexe(personnelsDTO.getSexe());
        updatedPersonnels.setLieuNaissance(personnelsDTO.getLieuNaissance());
        updatedPersonnels.setNumLicence(personnelsDTO.getNumLicence());
        updatedPersonnels.setAdresse(personnelsDTO.getAdresse());
        updatedPersonnels.setEmail(personnelsDTO.getEmail());
        updatedPersonnels.setTelephone(personnelsDTO.getTelephone());
        updatedPersonnels.setDateNaissance(personnelsDTO.getDateNaissance());
        updatedPersonnels.setSpecialite(personnelsDTO.getSpecialite());
        updatedPersonnels.setEtat(personnelsDTO.getEtat());
        updatedPersonnels.setRole(personnelsDTO.getRole());
        updatedPersonnels.setLogin(personnelsDTO.getLogin());
        updatedPersonnels.setDateInscription(personnelsDTO.getDateInscription());

        if (personnelsDTO.getPassword() != null) {
            updatedPersonnels.setPassword(this.passwordEncoder.encode(personnelsDTO.getPassword()));
        }

        updatedPersonnels = personnelsRepository.save(updatedPersonnels);

        return updatedPersonnels;
    }

    @Override
    public List<Personnels> getMedecins() {
        return personnelsRepository.findMedecins();
    }

}
