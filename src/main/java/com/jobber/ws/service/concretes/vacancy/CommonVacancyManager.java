package com.jobber.ws.service.concretes.vacancy;

import com.jobber.ws.model.factory.abstracts.AbstractVacancyFactory;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.service.abstracts.common.CommonVacancyService;
import com.jobber.ws.dataAccess.vacancy.GeneralVacancyRepository;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.factory.AbstractResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public final class CommonVacancyManager implements CommonVacancyService {

    private final AbstractResponseFactory<Vacancy> responseFactory;
    private final AbstractResponseFactory<List<SimpleVacancyDTO>> responseFactoryAsList;
    private final GeneralVacancyRepository generalVacancyRepository;
    private final AbstractVacancyFactory vacancyFactory;


    @Override
    public DataResponse<Vacancy> findById(Long vacancyId) {
        return responseFactory.factorySuccessDataResult(
                generalVacancyRepository.getByIdAndDeletedFalseAndActiveTrue(vacancyId)
        );
    }

}
