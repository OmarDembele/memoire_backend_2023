package com.esmt.memoire_back2023.impService;

import com.esmt.memoire_back2023.dto.AdminDTO;
import com.esmt.memoire_back2023.entity.Admin;
import com.esmt.memoire_back2023.entity.Personnels;
import com.esmt.memoire_back2023.repository.AdminRepository;
import com.esmt.memoire_back2023.services.AdminService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public void deleteAdmin(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin non trouvé avec l'ID : " + id));
        adminRepository.delete(admin);
    }

    @Override
    public Admin updateAdmin(Long id, AdminDTO adminDTO) {
        Admin adminToUpdate = convertDTOToEntity(adminDTO);

        Optional<Admin> existingAdmin = adminRepository.findById(id);
        if (!existingAdmin.isPresent()) {
            return null;
        }
        Admin updatedAdmin = existingAdmin.get();

        updatedAdmin.setNom(adminToUpdate.getNom());
        updatedAdmin.setPrenom(adminToUpdate.getPrenom());
        updatedAdmin.setSexe(adminToUpdate.getSexe());
        updatedAdmin.setLieuNaissance(adminToUpdate.getLieuNaissance());
        updatedAdmin.setNumLicence(adminToUpdate.getNumLicence());
        updatedAdmin.setStatus(adminToUpdate.getStatus());
        updatedAdmin.setRole(adminToUpdate.getRole());
        updatedAdmin.setSpecialite(adminToUpdate.getSpecialite());
        updatedAdmin.setLogin(adminToUpdate.getLogin());

        if (adminDTO.getPassword() != null) {
            updatedAdmin.setPassword(this.passwordEncoder.encode(adminDTO.getPassword()));
        }

        updatedAdmin = adminRepository.save(updatedAdmin);

        return updatedAdmin;
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
