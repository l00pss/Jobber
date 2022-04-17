package com.jobber.ws.model.entity.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SALARY")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Salary {
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;
    /**
     * 1 - Ayliq
     * 2 - Illik
     * 3 - Saatliq
     * 4 - Cari
     */
    @Column(name = "SALARY_PERIOD")
    private Integer period = 1;

    @Column(name = "SALARY_START")
    private BigDecimal salaryStart = new BigDecimal("0.00");

    @Column(name = "SALARY_UNTIL")
    private BigDecimal salaryUntil = new BigDecimal("0.00");
    /**
     * AZN, USD, EUR
     */
    @Column(name = "EXCHANGE")
    private String exchange = " AZN";

    @Override
    public String toString() {
        return salaryStart +" - " + salaryUntil + exchange;
    }
}