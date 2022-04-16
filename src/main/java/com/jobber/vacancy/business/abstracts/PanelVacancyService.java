package com.jobber.vacancy.business.abstracts;

import com.jobber.vacancy.model.dto.request.NewVacancyDTO;
import com.jobber.vacancy.model.dto.response.SimpleListVacancyDTO;
import com.jobber.vacancy.model.dto.response.ViewVacancyDTO;
import com.jobber.vacancy.model.entity.Vacancy;
import com.jobber.vacancy.side.response.DataResponse;
import com.jobber.vacancy.side.response.Response;
import com.jobber.vacancy.side.response.SimplePageable;

import java.util.List;

public interface PanelVacancyService {

    DataResponse<ViewVacancyDTO> save(NewVacancyDTO newVacancyDTO);

    Response delete(Long vacancyId);

    DataResponse<List<SimpleListVacancyDTO>> findAll();

    DataResponse<List<SimpleListVacancyDTO>> findAll(SimplePageable pageable);

    DataResponse<ViewVacancyDTO> open(Long id);

}
