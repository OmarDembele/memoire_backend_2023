package com.esmt.memoire_back2023.controller;


import com.esmt.memoire_back2023.dto.PersonnelsDTO;
import com.esmt.memoire_back2023.entity.Personnels;
import com.esmt.memoire_back2023.services.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
