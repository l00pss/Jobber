package com.jobber.ws.service.abstracts.common;


import com.jobber.ws.model.filter.concretes.CompanyFilter;
import com.jobber.ws.model.dto.response.company.SimpleCompanyDTO;
import com.jobber.ws.model.dto.response.company.ViewCompanyDTO;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.SimplePageable;

import java.util.List;

public interface CommonCompanyService {
    DataResponse<List<SimpleCompanyDTO>> findAll(SimplePageable simplePageable);

    DataResponse<List<SimpleCompanyDTO>> findAllByFilter(SimplePageable simplePageable, CompanyFilter vacancyFilter);

    DataResponse<ViewCompanyDTO> openById(String companyId);

    DataResponse<ViewCompanyDTO> showContact(String companyId);

    DataResponse<List<SimpleVacancyDTO>> findAllVacancyOfCompany(String companyId,SimplePageable pageable);

    DataResponse<List<SimpleVacancyDTO>> findPopularCompanies(SimplePageable pageable);
}
