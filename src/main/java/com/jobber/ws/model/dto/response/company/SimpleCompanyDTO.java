package com.jobber.ws.model.dto.response.company;

import com.jobber.ws.model.entity.company.Company;

public class SimpleCompanyDTO {
    private final String name;
    private final String logo;
    private final Integer vacancyCount;

    public SimpleCompanyDTO(Company company){
        this.name = company.getName();
        this.logo = company.getLogo();
        this.vacancyCount = company.getVacancies().size();
    }
}
