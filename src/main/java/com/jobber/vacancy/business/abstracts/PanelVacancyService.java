package com.jobber.vacancy.business.abstracts;

import com.jobber.vacancy.model.dto.request.NewVacancyDTO;
import com.jobber.vacancy.model.entity.Vacancy;
import com.jobber.vacancy.side.response.DataResponse;
import com.jobber.vacancy.side.response.Response;

public interface PanelVacancyService {

    DataResponse<Vacancy> save(NewVacancyDTO newVacancyDTO);

    Response delete(Long vacancyId);
}
