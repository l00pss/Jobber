package com.jobber.ws.business.abstracts.panel;

import com.jobber.ws.model.dto.request.NewVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.ViewVacancyDTO;
import com.jobber.ws.core.response.DataResponse;
import com.jobber.ws.core.response.Response;
import com.jobber.ws.core.response.SimplePageable;

import java.util.List;

public interface PanelVacancyService {

    DataResponse<ViewVacancyDTO> save(NewVacancyDTO newVacancyDTO);

    Response delete(Long vacancyId);

    DataResponse<List<SimpleVacancyDTO>> findAll();

    DataResponse<List<SimpleVacancyDTO>> findAll(SimplePageable pageable);

    DataResponse<ViewVacancyDTO> open(Long id);

}
