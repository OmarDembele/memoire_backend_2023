package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.AdminDTO;
import com.esmt.memoire_back2023.entity.Admin;
import com.esmt.memoire_back2023.entity.Personnels;
import com.esmt.memoire_back2023.repository.AdminRepository;
import com.esmt.memoire_back2023.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminImpl implements AdminService {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public AdminRepository adminRepository;

    @Override
    public Admin creerAdmin(AdminDTO adminDTO) {
        Admin admin = convertDTOToEntity(adminDTO);
        adminRepository.save(admin);
        return admin;
    }

    private Admin convertDTOToEntity(AdminDTO adminDTO) {

        Admin admin = new Admin();
        admin.setNom(adminDTO.getNom());
        admin.setPrenom(adminDTO.getPrenom());
        admin.setSexe(adminDTO.getSexe());
        admin.setLieuNaissance(adminDTO.getLieuNaissance());
        admin.setNumLicence(adminDTO.getNumLicence());
        admin.setStatus(adminDTO.getStatus());
        admin.setRole(adminDTO.getRole());
        admin.setSpecialite(adminDTO.getSpecialite());
        admin.setLogin(adminDTO.getLogin());
        admin.setPassword(this.passwordEncoder.encode(adminDTO.getPassword()));
        return admin;

    }


}


/*private Utilisateur convertDTOToUtilisateur(UtilisateurDTO utilisateurDTO) {

        Utilisateur utilisateur = new Utilisateur();

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
