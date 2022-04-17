package com.jobber.ws.model.entity.contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "EMAILS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = Contact.class,fetch = FetchType.LAZY)
    @JoinColumn(name="contact_id", nullable=false)
    private Contact contact;

    @Column(name = "EMAIL")
    private String email;
}