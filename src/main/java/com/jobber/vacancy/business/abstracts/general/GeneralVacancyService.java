package com.jobber.vacancy.business.abstracts.general;

import com.jobber.vacancy.model.entity.company.Vacancy;
import com.jobber.vacancy.side.response.DataResponse;

public interface GeneralVacancyService {

    DataResponse<Vacancy> findById(Long vacancyId);

}
