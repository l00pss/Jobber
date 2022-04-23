package com.jobber.ws.business.concretes.vacancy;

import com.jobber.ws.business.abstracts.jobber.JobberVacancyService;
import com.jobber.ws.dataAccess.vacancy.JobberVacancyRepository;
import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.util.response.Response;
import com.jobber.ws.util.response.factory.AbstractResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobberVacancyManager implements JobberVacancyService {
    private final AbstractResponseFactory<Vacancy> responseFactory;
    private final JobberVacancyRepository jobberVacancyRepository;

    @Override
    public Response deleteHard(Long vacancyId) {
        jobberVacancyRepository.delete(jobberVacancyRepository.getById(vacancyId));
        return responseFactory.factorySuccessResult("Vakansiya uğurla sistemlən silindi.");
    }

    @Override
    public Response deleteSimple(Long vacancyId) {
        Vacancy vacancy = jobberVacancyRepository.getById(vacancyId);
        vacancy.delete();
        jobberVacancyRepository.save(vacancy);
        return responseFactory.factorySuccessResult("Vakansiya uğurla silindi.");
    }
}
