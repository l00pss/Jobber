package com.jobber.ws.business.abstracts.common;

import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.core.response.DataResponse;

public interface CommonVacancyService {

    DataResponse<Vacancy> findById(Long vacancyId);

}
