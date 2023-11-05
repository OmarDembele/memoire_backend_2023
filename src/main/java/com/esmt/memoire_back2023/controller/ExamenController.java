package com.esmt.memoire_back2023.controller;


import com.esmt.memoire_back2023.dto.ExamenDTO;
import com.esmt.memoire_back2023.entity.ExamenMedical;
import com.esmt.memoire_back2023.entity.NextRv;
import com.esmt.memoire_back2023.services.ExamenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/examen")
public class ExamenController {

    @Autowired
    private ExamenService examenService;

    public ExamenController(ExamenService examenService) {
        this.examenService = examenService;
    }

    @PostMapping(path = "/save")
    private ExamenMedical addExam(@RequestBody ExamenDTO examenDTO){
        ExamenMedical examenMedical = examenService.creerExamen(examenDTO);
        return examenMedical;
    }

    @DeleteMapping("/{id}")
    public void supprimerExam(@PathVariable Long id) {
        examenService.delleteExam(id);
    }

    @GetMapping(path = "/{id}")
    public ExamenMedical getExamenById(@PathVariable Long id) {
        return examenService.getExamenMedicalById(id);
    }

    @GetMapping("/personnel/{id}")
    public List<ExamenMedical> getAllExam(@PathVariable Long id) {
        return examenService.findByPersonnel(id);
    }

}
