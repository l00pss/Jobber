package com.jobber.ws.business.abstracts.panel;

import com.jobber.ws.model.dto.request.NewVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.SimpleListVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.ViewVacancyDTO;
import com.jobber.ws.side.response.DataResponse;
import com.jobber.ws.side.response.Response;
import com.jobber.ws.side.response.SimplePageable;

import java.util.List;

public interface PanelVacancyService {

    DataResponse<ViewVacancyDTO> save(NewVacancyDTO newVacancyDTO);

    Response delete(Long vacancyId);

    DataResponse<List<SimpleListVacancyDTO>> findAll();

    DataResponse<List<SimpleListVacancyDTO>> findAll(SimplePageable pageable);

    DataResponse<ViewVacancyDTO> open(Long id);

}
