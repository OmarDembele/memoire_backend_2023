package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.NextRvDTO;
import com.esmt.memoire_back2023.entity.NextRv;
import com.esmt.memoire_back2023.entity.Patient;
import com.esmt.memoire_back2023.services.NextRvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/nextrv")
public class NextRvController {

    @Autowired
    private NextRvService nextRvService;

    @PostMapping(path = "/save")
    private Long addrv(@RequestBody NextRvDTO nextRvDTO){
        NextRv nextRv = nextRvService.addRv(nextRvDTO);
        return new ResponseEntity<>(nextRv.getId(), HttpStatus.CREATED).getBody();
    }

    @DeleteMapping("/{id}")
    public void supprimerNextRV(@PathVariable Long id) {
        nextRvService.deleteNextRV(id);
    }
}
