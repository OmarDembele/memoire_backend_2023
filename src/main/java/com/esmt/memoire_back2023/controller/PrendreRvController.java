package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.PrendreRvDTO;
import com.esmt.memoire_back2023.entity.PrendreRv;
import com.esmt.memoire_back2023.services.PrendreRvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
