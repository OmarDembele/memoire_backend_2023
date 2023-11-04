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
        personnels.setLieuNaissance(personnelsDTO.getLieuNaissance());
        personnels.setNumLicence(personnelsDTO.getNumLicence());
        personnels.setType(personnelsDTO.getType());
        personnels.setStatus(personnelsDTO.getStatus());
        personnels.setSpecialite(personnelsDTO.getSpecialite());
        personnels.setEtat(personnelsDTO.getEtat());
        personnels.setRole(personnelsDTO.getRole());
        personnels.setLogin(personnelsDTO.getLogin());
        personnels.setPassword(this.passwordEncoder.encode(personnelsDTO.getPassword()));
        return personnels;

    }

    public List<PersonnelsDTO> getallPersonnels() {
        List<Personnels> personnels = personnelsRepository.findAll();

        //convertir la liste des personnels en liste de personnelsDTO
        List<PersonnelsDTO> personnelsDTOs = personnels.stream()
                .map(personnel -> new PersonnelsDTO(
                        personnel.getIdPersonnel(),
                        personnel.getNom(),
                        personnel.getPrenom(),
                        personnel.getSexe(),
                        personnel.getLieuNaissance(),
                        personnel.getNumLicence(),
                        personnel.getLogin(),
                        personnel.getPassword(),
                        personnel.getType(),
                        personnel.getStatus(),
                        personnel.getRole(),
                        personnel.getSpecialite(),
                        personnel.getEtat()
                ))
                .collect(Collectors.toList());

        return personnelsDTOs;


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
        updatedPersonnels.setType(personnelsDTO.getType());
        updatedPersonnels.setStatus(personnelsDTO.getStatus());
        updatedPersonnels.setSpecialite(personnelsDTO.getSpecialite());
        updatedPersonnels.setEtat(personnelsDTO.getEtat());
        updatedPersonnels.setRole(personnelsDTO.getRole());
        updatedPersonnels.setLogin(personnelsDTO.getLogin());

        if (personnelsDTO.getPassword() != null) {
            updatedPersonnels.setPassword(this.passwordEncoder.encode(personnelsDTO.getPassword()));
        }

        updatedPersonnels = personnelsRepository.save(updatedPersonnels);

        return updatedPersonnels;
    }

}
