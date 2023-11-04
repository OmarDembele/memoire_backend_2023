package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.ConsultationDTO;
import com.esmt.memoire_back2023.entity.Consultation;
import com.esmt.memoire_back2023.services.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    public ConsultationController(ConsultationService consultationService) {
        this.consultationService = consultationService;
    }

    @PostMapping(path = "/save")
    public Consultation addConsultation(@RequestBody ConsultationDTO consultationDTO) {
        Consultation consultation = consultationService.addConsultation(consultationDTO);
        return consultation;
    }

    @DeleteMapping("/{id}")
    public void supprimerConsultation(@PathVariable Long id) {
        consultationService.deleteConsultation(id);
    }


    @GetMapping("/consultations")
    public List<Consultation> getAllConsultation()  {
        return consultationService.getAllConsultations();
    }

    @GetMapping(path = "/{id}")
    public Consultation getConsultationById(@PathVariable Long id) {
        return consultationService.getConsultationById(id);
    }





}
