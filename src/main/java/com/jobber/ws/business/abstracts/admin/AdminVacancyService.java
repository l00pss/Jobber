package com.jobber.ws.business.abstracts.admin;

import com.jobber.ws.model.dto.request.NewVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.ViewVacancyDTO;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.Response;
import com.jobber.ws.util.response.SimplePageable;

import java.util.List;

public interface AdminVacancyService {

    DataResponse<ViewVacancyDTO> save(NewVacancyDTO newVacancyDTO);

    Response delete(Long vacancyId);

    DataResponse<List<SimpleVacancyDTO>> findAll();

    DataResponse<List<SimpleVacancyDTO>> findAll(SimplePageable pageable);

    DataResponse<ViewVacancyDTO> open(Long id);

}
