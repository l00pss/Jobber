package com.jobber.ws.business.concretes.vacancy;

import com.jobber.ws.model.factory.abstracts.AbstractVacancyFactory;
import com.jobber.ws.model.dto.response.vacancy.SimpleListVacancyDTO;
import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.business.abstracts.general.GeneralVacancyService;
import com.jobber.ws.dataAccess.vacancy.GeneralVacancyRepository;
import com.jobber.ws.side.response.DataResponse;
import com.jobber.ws.side.response.factory.AbstractResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public final class GeneralVacancyManager implements GeneralVacancyService {

    private final AbstractResponseFactory<Vacancy> responseFactory;
    private final AbstractResponseFactory<List<SimpleListVacancyDTO>> responseFactoryAsList;
    private final GeneralVacancyRepository generalVacancyRepository;
    private final AbstractVacancyFactory vacancyFactory;


    @Override
    public DataResponse<Vacancy> findById(Long vacancyId) {
        return responseFactory.factorySuccessDataResult(
                generalVacancyRepository.getByIdAndDeletedFalseAndActiveTrue(vacancyId)
        );
    }

}
