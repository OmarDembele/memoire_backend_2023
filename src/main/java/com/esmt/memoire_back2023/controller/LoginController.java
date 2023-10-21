package com.esmt.memoire_back2023.controller;

import com.esmt.memoire_back2023.dto.LoginDTO;
import com.esmt.memoire_back2023.response_login.LoginMessage;
import com.esmt.memoire_back2023.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class LoginController {

    @Autowired
    public LoginService loginService;


    @PostMapping(path = "/login")
    public ResponseEntity<LoginMessage> loginUser(@RequestBody LoginDTO loginDTO){
        LoginMessage loginMessage = loginService.loginUser(loginDTO);
        return ResponseEntity.ok(loginMessage);
    }
}
