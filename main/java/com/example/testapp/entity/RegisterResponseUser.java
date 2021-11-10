package com.example.testapp.entity;

public class RegisterResponseUser {

    private String server_message;

    private String status;

    public String getServer_message() {
        return server_message;
    }

    public void setServer_message(String server_message) {
        this.server_message = server_message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RegisterResponseUser{" +
                "server_message='" + server_message + '\'' +
                ", status='" + status + '\'' +
                '}';

    }
}