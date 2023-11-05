package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.PrescriptionDTO;
import com.esmt.memoire_back2023.entity.ExamenMedical;
import com.esmt.memoire_back2023.entity.Prescription;
import com.esmt.memoire_back2023.entity.Soins;
import com.esmt.memoire_back2023.services.PrescriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/prescription")
public class PrescriptionController {

    private PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @PostMapping(path = "/save")
    private Prescription addPresc(@RequestBody PrescriptionDTO prescriptionDTO){
        Prescription prescription = prescriptionService.creerPresc(prescriptionDTO);
        return prescription;
    }

    @DeleteMapping("/{id}")
    public void supprimerPresc(@PathVariable Long id) {
        prescriptionService.delletePresc(id);
    }

    @GetMapping("/personnel/{id}")
    public List<Prescription> getAllPresc(@PathVariable Long id) {
        return prescriptionService.getPrescByPersonnelId(id);
    }
}
