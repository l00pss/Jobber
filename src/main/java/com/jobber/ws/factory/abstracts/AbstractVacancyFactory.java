package com.jobber.ws.factory.abstracts;

import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.model.dto.request.NewVacancyDTO;

public abstract class AbstractVacancyFactory {
    public abstract Vacancy factory();

    public abstract Vacancy factoryFromSimpleDto(NewVacancyDTO vacancyDTO);


}
