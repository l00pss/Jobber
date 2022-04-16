package com.jobber.ws.model.entity.contact;
import javax.persistence.*;
import javax.validation.constraints.Size;
@Entity
@Table(name = "PHONE_NUMBERS")
public class PhoneNumber {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = Contact.class,fetch = FetchType.EAGER)
    @JoinColumn(name="contact_id", nullable=false)
    private Contact contact;

    @Column(name = "COUNTRY_CODE")
    private String codeCountry = "+994";

    @Column(name = "PREFIX",nullable = false)
    @Size(min = 2,max = 2)
    private String prefix = "50";

    @Column(name = "NUMBER",nullable = false)
    @Size(min = 7,max = 12)
    private String number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeCountry() {
        return codeCountry;
    }

    public void setCodeCountry(String codeCountry) {
        this.codeCountry = codeCountry;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}