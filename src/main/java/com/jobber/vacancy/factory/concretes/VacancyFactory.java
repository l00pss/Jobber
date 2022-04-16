package com.jobber.vacancy.factory.concretes;

import com.jobber.vacancy.factory.abstracts.AbstractVacancyFactory;
import com.jobber.vacancy.model.dto.request.NewVacancyDTO;
import com.jobber.vacancy.model.entity.vacancy.Vacancy;
import org.springframework.stereotype.Component;

@Component
public class VacancyFactory extends AbstractVacancyFactory {
    @Override
    public Vacancy factory() {
        return new Vacancy();
    }

    @Override
    public Vacancy factoryFromSimpleDto(NewVacancyDTO vacancyDTO) {
        return new Vacancy(vacancyDTO);
    }
}
