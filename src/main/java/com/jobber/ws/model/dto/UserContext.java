package com.jobber.ws.model.dto;

import com.jobber.ws.model.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserContext implements Serializable {

    private static final long serialVersionUID = -8099349063069095844L;

    private String id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String type;

    public UserContext(User user){
        this.id = user.getId().toString();
        this.name = user.getProfile().getName();
        this.surname = user.getProfile().getLastName();
        this.email = user.getProfile().getEmail();
        this.password = user.getPassword();
    }
}