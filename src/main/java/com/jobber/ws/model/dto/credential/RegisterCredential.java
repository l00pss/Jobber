package com.jobber.ws.model.dto.credential;

import lombok.Getter;

@Getter
public final class RegisterCredential {

    private final String name;
    private final String lastName;
    private final String email;
    private final String userName;
    private final String password;

    public  RegisterCredential(String name,String lastName,String email,String userName,String password){
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
    }
}
