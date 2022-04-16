package com.jobber.vacancy.model.dto.response.vacancy;

import com.jobber.vacancy.model.entity.vacancy.Vacancy;
import lombok.Getter;

import java.util.Date;

@Getter
public class ViewVacancyDTO {

    private static transient Vacancy vacancy;

    private final Long id;

    private final String title;

    private final String context;

    private final Date dueDate;

    private final Date createDate;

    private ViewVacancyDTO(Vacancy vacancy){
        this.id = vacancy.getId();
        this.title = vacancy.getTitle();
        this.context = vacancy.getContext();
        this.dueDate = vacancy.getDueDate();
        this.createDate = vacancy.getCreateDate();
    }

    public static ViewVacancyDTO factory(Vacancy vacancy){
        return new ViewVacancyDTO(vacancy);
    }

}
