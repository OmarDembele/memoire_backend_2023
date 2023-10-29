package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.HospitalisationDTO;
import com.esmt.memoire_back2023.entity.Hospitalisation;
import com.esmt.memoire_back2023.services.HospitalisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/hospitalisation")
public class HospitalisationController {

    @Autowired
    private HospitalisationService hospitalisationService;

    public HospitalisationController(HospitalisationService hospitalisationService) {
        this.hospitalisationService = hospitalisationService;
    }

    @PostMapping(path = "/save")
    private Hospitalisation addHospi(@RequestBody HospitalisationDTO hospitalisationDTO){
        Hospitalisation hospitalisation = hospitalisationService.creerHospi(hospitalisationDTO);
        return hospitalisation;
    }

    @DeleteMapping("/{id}")
    public void supprimerHospi(@PathVariable Long id) {
        hospitalisationService.deleteHospi(id);
    }
}
