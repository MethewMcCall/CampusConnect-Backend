package com.campusconnect.campusconnect_backend.dto;

import lombok.Getter;
import lombok.Setter;

public class RegisterRequest {
    private String name;
    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private String password;

    public String getFullName() {
        return name;
    }

    public void setFullName(String name) {
        this.name = name;
    }

}
