package com.jobber.ws.model.dto.response.vacancy;

import com.jobber.ws.model.entity.company.Vacancy;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public final class SimpleVacancyDTO {
    private final UUID id;

    private final String title;

    private final String context;

    private final Date dueDate;

    private final Date createDate;

    public SimpleVacancyDTO(Vacancy vacancy){
        this.id = vacancy.getId();
        this.title = vacancy.getTitle();
        this.context = vacancy.getOpportunity();
        this.dueDate = vacancy.getExpiredDate();
        this.createDate = vacancy.getCreateDate();
    }

}
