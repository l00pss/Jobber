package com.jobber.ws.factory.concretes;

import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.factory.abstracts.AbstractVacancyFactory;
import com.jobber.ws.model.dto.request.NewVacancyDTO;
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
