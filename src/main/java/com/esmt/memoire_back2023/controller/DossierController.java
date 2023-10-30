package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.DossierDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.services.DossierService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/dossier")
public class DossierController {

    @Autowired
    private DossierService dossierService;

    public DossierController(DossierService dossierService) {
        this.dossierService = dossierService;
    }


    @PostMapping(path = "/save")
    public DossierMedical addDossier(@RequestBody DossierDTO dossierDTO) {
        DossierMedical dossierMedical = dossierService.creerDossier(dossierDTO);
        return dossierMedical;
    }

    @GetMapping(path = "/dossiers")
    public List<DossierDTO> getAllDossiers() {
        return dossierService.obtenirTousLesDossiers();
    }

    @DeleteMapping("/{id}")
    public void supprimerDossier(@PathVariable Long id) {
        dossierService.deleteDossier(id);
    }

    @GetMapping(path = "/{id}")
    public DossierDTO getDossierMedicalById(@PathVariable Long id) {
        return dossierService.getDossierMedicalById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DossierDTO> updateDossierMedical(@PathVariable Long id, @RequestBody DossierDTO dossierDTO) {
        try {
            DossierMedical updatedDossier = dossierService.updateDossierMedical(id, dossierDTO);
            DossierDTO updatedDossierDTO = new DossierDTO(updatedDossier.getIdDossier(), updatedDossier.getDateCreation(), updatedDossier.getDescription());
            return ResponseEntity.ok(updatedDossierDTO);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }




}
