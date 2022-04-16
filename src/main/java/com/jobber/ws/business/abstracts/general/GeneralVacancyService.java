package com.jobber.ws.business.abstracts.general;

import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.side.response.DataResponse;

public interface GeneralVacancyService {

    DataResponse<Vacancy> findById(Long vacancyId);

}
