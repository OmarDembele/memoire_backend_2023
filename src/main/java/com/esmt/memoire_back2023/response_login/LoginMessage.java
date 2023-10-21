package com.esmt.memoire_back2023.response_login;

public class LoginMessage {

    private String message;

    private Boolean status;

    private String role;

    private String token;

    public LoginMessage() {
    }

    public LoginMessage(String message, Boolean status) {
        this.message = message;
        this.status = status;
    }

    public LoginMessage(String message, Boolean status, String role) {
        this.message = message;
        this.status = status;
        this.role = role;
    }

    public LoginMessage(String message, Boolean status, String role, String token) {
        this.message = message;
        this.status = status;
        this.role = role;
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getStatus() {
        return status;
    }

    public String getRole() {
        return role;
    }

    public String getToken() {
        return token;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

