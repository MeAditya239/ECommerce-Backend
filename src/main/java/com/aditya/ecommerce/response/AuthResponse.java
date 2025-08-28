package com.aditya.ecommerce.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class AuthResponse {

    private String jwt;
    private String message;

    public AuthResponse(String jwt, String message) {
        super();
        this.jwt = jwt;
        this.message = message;
    }

    public AuthResponse() {

    }






}
