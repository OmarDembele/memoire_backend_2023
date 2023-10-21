package com.esmt.memoire_back2023.impService;


import com.esmt.memoire_back2023.dto.LoginDTO;
import com.esmt.memoire_back2023.entity.Admin;
import com.esmt.memoire_back2023.entity.Personnels;
import com.esmt.memoire_back2023.repository.AdminRepository;
import com.esmt.memoire_back2023.repository.PersonnelsRepository;
import com.esmt.memoire_back2023.response_login.LoginMessage;
import com.esmt.memoire_back2023.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginImpl implements LoginService {

    @Autowired
    public PasswordEncoder passwordEncoder;

    @Autowired
    public AdminRepository adminRepository;


    //public JwtTokenUtil jwtTokenUtil;

    @Autowired
    public PersonnelsRepository personnelsRepository;

    @Override
    public LoginMessage loginUser(LoginDTO loginDTO) {

        Admin admin1 = adminRepository.findByLogin(loginDTO.getLogin());

        System.out.println(admin1);

        Personnels personnels = personnelsRepository.findByLogin(loginDTO.getLogin());

        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJhdWQiOiIxIiwianRpIjoiZTJlODA4OGRkYTlhMGY5MzBkMjNhMjNkMDI3YTcwMjBkMzlkNTkwOTVjOGYyYjE5YTQ0N2YwNTE0MDlkMzI2Y2JjYjA4ZTZjOTE0NzViOTQiLCJpYXQiOjE2OTcxOTEyMTEsIm5iZiI6MTY5NzE5MTIxMSwiZXhwIjoxNzI4ODEzNjExLCJzdWIiOiIxNSIsInNjb3BlcyI6W119.Pd5GwAgXgXKoCQ0sXSjYdBIqfgWGkv8gXsmN9fVYNNCQVfM8tK_RTXloWrjTlKZYyguY5i8hDslqtHCl--ycHMtNpUpfcloIyktLvuqSqzzZLHFvzF5gOO1u_TrgOingM9W9KxcAI-fiWe_L8ybwi4k0dXziDFe9DcHV2nHYzTvvuFHcTDed7TSentAng7bVtLKaTnX8MnAUNyTJGmnJ6YJwS3ELkvY64680Ktf9t1gGgsU5OAMe22N1yvx0kv4u9QBMr8Z4OQ3V2he_lJOg30ZmtJgoSxzSGHXDPubcf-8Fz2c20xk11ZTJ33Q2XHSmwKFi2zBbuzeCylx_-Q4NO5AoXx2FtfJef3suQQB6iPgHOdNifo2tHEHzUnQ6DLgdlNr30hAgY96GeXMCJ1GogUe91lmOJ7B_S-h7IgHnMcjUIynepTHzxt6A7ttskMd3345TypbWsJulRUBJVa8fBGqTvVcuZM9H1PCQI5odhcVmrrpjqgoVd37K7SU4cK8Sl54Sp0vHM86R7993c87u80ifwiAmI0WwBRd1VTJW1-Xxy8bYp1aIa98hgTVsGyJsqRZbr2QCmM_XrLClB-KWTgAahhCb3nIph7h3FeQyO30VrTNABTt9KDsE2nS7LnPdmGX79I0fqNCXZ9PcRnGN_N_AwxWd10n5jfjyZMPMC3k";

        System.out.println(personnels);

        if(admin1 != null){
            String password = loginDTO.getPassword();
            String encodedPassword = admin1.getPassword();
            String type = String.valueOf(admin1.getType());
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if(isPwdRight){
                Optional<Admin> admin = adminRepository.findOneByLoginAndPassword(loginDTO.getLogin(), encodedPassword);

                if(admin.isPresent()){
                    return new LoginMessage("Login Success", true, type);
                }
                else{
                    return new LoginMessage("Login Failed", false, type);
                }
            }
            else{
                return new LoginMessage("Password not match", false, type);
            }
        }
        else if(personnels != null) {
            String password = loginDTO.getPassword();
            String role = personnels.getType().name();
            String encodedPassword = personnels.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if(isPwdRight){
                Optional<Personnels> personnel = personnelsRepository.findOneByLoginAndPassword(loginDTO.getLogin(), encodedPassword);
                if(personnel.isPresent()){
                    return new LoginMessage("Login Success", true, role, token);
                }
                else{
                    return new LoginMessage("Login Failed", false, role);
                }
            }
            else{
                return new LoginMessage("Password not match", false, role);
            }
        }
        else{
            return new LoginMessage("Login not exits", false);
        }
    }
}


