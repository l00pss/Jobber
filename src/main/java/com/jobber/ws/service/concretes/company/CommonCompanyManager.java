package com.jobber.ws.service.concretes.company;

import com.jobber.ws.model.filter.concretes.CompanyFilter;
import com.jobber.ws.dataAccess.company.CommonCompanyRepository;
import com.jobber.ws.model.dto.response.company.SimpleCompanyDTO;
import com.jobber.ws.model.dto.response.company.ViewCompanyDTO;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.model.entity.company.Company;
import com.jobber.ws.service.abstracts.common.CommonCompanyService;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.SimplePageable;
import com.jobber.ws.util.response.factory.AbstractResponseFactory;
import com.jobber.ws.util.response.message.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommonCompanyManager implements CommonCompanyService {

    private final CommonCompanyRepository companyRepository;
    private final AbstractResponseFactory<List<SimpleCompanyDTO>> simpleCompanyDTOAbstractResponseFactory;
    private final AbstractResponseFactory<ViewCompanyDTO> viewCompanyDTOAbstractResponseFactory;


    @Override
    public DataResponse<List<SimpleCompanyDTO>> findAll(SimplePageable simplePageable) {
        var companyList = this.companyRepository
                .findAll(simplePageable.factory())
                .stream()
                .filter(Company::isAppropriate)
                .map(SimpleCompanyDTO::new)
                .collect(Collectors.toUnmodifiableList());
        return simpleCompanyDTOAbstractResponseFactory
                .factorySuccessDataResult(companyList, ResponseMessage.SUCCESSFUL.get("200_100012"));
    }

    @Override
    public DataResponse<List<SimpleCompanyDTO>> findAllByFilter(SimplePageable simplePageable, CompanyFilter companyFilter) {
        var companyList = this.companyRepository
                .findAll()
                .stream()
                .filter(companyFilter::filter)
                .map(SimpleCompanyDTO::new)
                .collect(Collectors.toUnmodifiableList());
        return null;
    }

    @Override
    public DataResponse<ViewCompanyDTO> openById(String companyId) {
        return null;
    }

    @Override
    public DataResponse<ViewCompanyDTO> showContact(String companyId) {
        return null;
    }

    @Override
    public DataResponse<List<SimpleVacancyDTO>> findAllVacancyOfCompany(String companyId, SimplePageable pageable) {
        return null;
    }

    @Override
    public DataResponse<List<SimpleVacancyDTO>> findPopularCompanies(SimplePageable pageable) {
        return null;
    }
}
