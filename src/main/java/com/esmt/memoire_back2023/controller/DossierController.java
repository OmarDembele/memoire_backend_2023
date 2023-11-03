package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.DossierDTO;
import com.esmt.memoire_back2023.entity.DossierMedical;
import com.esmt.memoire_back2023.services.DossierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping()
    public List<DossierDTO> getAllDossiers() {
        return dossierService.obtenirTousLesDossiers();
    }


    @GetMapping("/{id}")
    public Optional<DossierMedical> getDossierById(@PathVariable Long id) {
        Optional<DossierMedical> dossierMedical = dossierService.getDossierById(id);
        return dossierMedical;
    }

}
