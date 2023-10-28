package com.esmt.memoire_back2023.controller;


import com.esmt.memoire_back2023.dto.AdminDTO;
import com.esmt.memoire_back2023.entity.Admin;
import com.esmt.memoire_back2023.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping(path = "/save")
    public Admin addAdmin(@RequestBody AdminDTO adminDTO) {
        Admin admin = adminService.creerAdmin(adminDTO);
        return admin;
    }

    @DeleteMapping("/{id}")
    public void supprimerAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody AdminDTO adminDTO) {
        Admin updatedAdmin = adminService.updateAdmin(id, adminDTO);
        if (updatedAdmin != null) {
            return ResponseEntity.ok(updatedAdmin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
