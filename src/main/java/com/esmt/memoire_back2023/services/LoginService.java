package com.esmt.memoire_back2023.services;

import com.esmt.memoire_back2023.dto.LoginDTO;
import com.esmt.memoire_back2023.response_login.LoginMessage;

public interface LoginService {
    LoginMessage loginUser(LoginDTO loginDTO);
}
