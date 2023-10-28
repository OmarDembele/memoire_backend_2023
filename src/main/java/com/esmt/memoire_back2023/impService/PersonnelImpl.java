package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.PersonnelsDTO;
import com.esmt.memoire_back2023.entity.Personnels;
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

   /* private Utilisateur convertDTOToUtilisateur(UtilisateurDTO utilisateurDTO) {

        Utilisateur utilisateur = new Utilisateur();

        utilisateur.setId(utilisateur.getId());
        utilisateur.setNom(utilisateurDTO.getNom());
        utilisateur.setPrenom(utilisateurDTO.getPrenom());
        utilisateur.setSexe(utilisateurDTO.getSexe());
        utilisateur.setLieuNaissance(utilisateurDTO.getLieuNaissance());
        utilisateur.setNumLicence(utilisateurDTO.getNumLicence());
        utilisateur.setType(utilisateurDTO.getType());
        utilisateur.setStatus(utilisateurDTO.getStatus());
        utilisateur.setLogin(utilisateurDTO.getLogin());
        this.passwordEncoder.encode(utilisateurDTO.getPassword());
        return utilisateur;

    }*/
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
    public PersonnelsDTO getPersonnelById(Long id) {
        Personnels personnel = personnelsRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Personnel non trouvé avec l'ID : " + id));

        return new PersonnelsDTO(
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
        );
    }


}
