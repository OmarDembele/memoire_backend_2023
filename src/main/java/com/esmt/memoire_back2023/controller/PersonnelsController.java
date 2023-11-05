package com.esmt.memoire_back2023.controller;


import com.esmt.memoire_back2023.dto.PersonnelsDTO;
import com.esmt.memoire_back2023.entity.Personnels;
import com.esmt.memoire_back2023.entity.UserRole;
import com.esmt.memoire_back2023.services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/personnels")
public class PersonnelsController {

    @Autowired
    private PersonnelService personnelService;

    public PersonnelsController(PersonnelService personnelService) {
        this.personnelService = personnelService;
    }

    @PostMapping(path = "/save")
    public Personnels addPersonnel(@RequestBody PersonnelsDTO personnelsDTO) {
        Personnels personnels = personnelService.creerPersonnels(personnelsDTO);
        return personnels;
    }
    @GetMapping(path = "/list")
    public List<Personnels> getAllPersonnels() {
        return personnelService.getallPersonnels();
    }

    @GetMapping(path = "id/{id}")
    public Optional<Personnels> getPersonnelById(@PathVariable Long id) {
        Optional<Personnels> personnels = personnelService.getPersonnelById(id);
        return personnels;
    }

    @DeleteMapping("/{id}")
    public void supprimerPersonnel(@PathVariable Long id) {
        personnelService.deletePersonnel(id);
    }

    @GetMapping("/{role}")
    public List<Personnels> trierPersonnelsParRole(@PathVariable String role) {
        UserRole userRole = UserRole.valueOf(role);
        return personnelService.trierParRole(userRole);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personnels> updateersonnel(@PathVariable Long id, @RequestBody PersonnelsDTO personnelsDTO) {
        Personnels updatedPersonnels = personnelService.updatePersonnels(id, personnelsDTO);
        if (updatedPersonnels != null) {
            return ResponseEntity.ok(updatedPersonnels);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
