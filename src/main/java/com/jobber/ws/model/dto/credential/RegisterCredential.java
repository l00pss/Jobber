package com.jobber.ws.model.dto.credential;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterCredential {
    private String name;
    private String lastName;
    private String email;
    private String userName;
    private String password;
}
