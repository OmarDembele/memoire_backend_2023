package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.ConsultationDTO;
import com.esmt.memoire_back2023.dto.NextRvDTO;
import com.esmt.memoire_back2023.entity.Consultation;
import com.esmt.memoire_back2023.entity.Hospitalisation;
import com.esmt.memoire_back2023.entity.NextRv;
import com.esmt.memoire_back2023.services.NextRvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/nextrv")
public class NextRvController {

    @Autowired
    private NextRvService nextRvService;

    public NextRvController(NextRvService nextRvService) {
        this.nextRvService = nextRvService;
    }

    @PostMapping(path = "/save")
    private NextRv addrv(@RequestBody NextRvDTO nextRvDTO){
        NextRv nextRv = nextRvService.addRv(nextRvDTO);
        return nextRv;
    }

    @DeleteMapping("/{id}")
    public void supprimerNextRV(@PathVariable Long id) {
        nextRvService.deleteNextRV(id);
    }

    @GetMapping("/personnel/{id}")
    public List<NextRv> getAllRv(@PathVariable Long id) {
        return nextRvService.getAllRv(id);
    }
}
