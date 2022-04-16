package com.jobber.ws.model.entity.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SALARY")
public class Salary {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;
    /**
     * 1 - Ayliq
     * 2 - Illik
     * 3 - Saatliq
     * 4 - Cari
     */
    @Column(name = "SALARY_PERIOD")
    private Integer period = 1;

    @Column(name = "SALARY")
    private Double salary = 0.00;
    /**
     * AZN, USD, EUR
     */
    @Column(name = "EXCHANGE")
    private String exchange = "AZN";

    @Override
    public String toString() {
        return salary + exchange;
    }
}