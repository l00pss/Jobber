package com.jobber.ws.model.dto;

import com.jobber.ws.model.entity.user.JUser;
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

    public UserContext(JUser JUser){
        this.id = JUser.getId().toString();
        this.name = JUser.getJUserProfile().getFirstname();
        this.surname = JUser.getJUserProfile().getLastName();
        this.email = JUser.getJUserProfile().getEmail();
        this.password = JUser.getPassword();
    }
}