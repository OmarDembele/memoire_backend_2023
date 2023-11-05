package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.SoinsDTO;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.entity.Soins;
import com.esmt.memoire_back2023.services.SoinsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/soins")
public class SoinsController {

    @Autowired
    private SoinsService soinsService;

    public SoinsController(SoinsService soinsService) {
        this.soinsService = soinsService;
    }

    @PostMapping("/save")
    private Soins addSoins(@RequestBody SoinsDTO soinsDTO){
        Soins soins = soinsService.creerSoins(soinsDTO);
        return soins;
    }

    @GetMapping("/byPersonnelId/{personnelId}")
    public List<Soins> getSoinsByPersonnelId(@PathVariable Long personnelId) {
        List<Soins> soins = soinsService.getAllSoinsByPersonnelId(personnelId);
        return soins;
    }

    @DeleteMapping("/{id}")
    public void supprimerSoins(@PathVariable Long id) {
        soinsService.deleteSoins(id);
    }
}
