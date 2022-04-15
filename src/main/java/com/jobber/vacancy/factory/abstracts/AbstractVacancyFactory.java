package com.jobber.vacancy.factory.abstracts;

import com.jobber.vacancy.model.dto.request.NewVacancyDTO;
import com.jobber.vacancy.model.entity.Vacancy;

public abstract class AbstractVacancyFactory {
    public abstract Vacancy factory();
    public abstract Vacancy factoryFromSimpleDto(NewVacancyDTO vacancyDTO);

}
