package com.esmt.memoire_back2023.dto;


public class LoginDTO {

    private String login;
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
