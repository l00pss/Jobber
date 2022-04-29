package com.jobber.ws.service.abstracts.common;

import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.util.response.DataResponse;

public interface CommonVacancyService {

    DataResponse<Vacancy> findById(Long vacancyId);

}
