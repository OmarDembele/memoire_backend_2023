package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.PrendreRvDTO;
import com.esmt.memoire_back2023.entity.PrendreRv;
import com.esmt.memoire_back2023.services.PrendreRvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/prendrerv")
public class PrendreRvController {

    @Autowired
    private PrendreRvService prendreRvService;

    public PrendreRvController(PrendreRvService prendreRvService) {
        this.prendreRvService = prendreRvService;
    }

    @PostMapping(path = "/save")
    public PrendreRv prendreRv(@RequestBody PrendreRvDTO prendreRvDTO) {
        PrendreRv prendreRv = prendreRvService.prendreRv(prendreRvDTO);
        return prendreRv;
    }

    @GetMapping(path = "/list")
    public List<PrendreRvDTO> getAllPrendreRv() {
        return prendreRvService.getallPrendreRv();
    }
    @GetMapping(path = "/{id}")
    public PrendreRvDTO getPrendreRvById(@PathVariable Long id) {
        return prendreRvService.getPrendreRvById(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerPrendreRV(@PathVariable Long id) {
        prendreRvService.deletePrendreRvService(id);
    }
}
