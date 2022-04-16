package com.jobber.vacancy.business.abstracts.vacancy;

import com.jobber.vacancy.model.entity.vacancy.Vacancy;
import com.jobber.vacancy.side.response.DataResponse;

public interface GeneralVacancyService {

    DataResponse<Vacancy> findById(Long vacancyId);

}
