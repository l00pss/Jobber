package com.jobber.vacancy.business.concretes;

import com.jobber.vacancy.business.abstracts.JobberVacancyService;
import com.jobber.vacancy.dataAccess.JobberVacancyRepository;
import com.jobber.vacancy.model.entity.Vacancy;
import com.jobber.vacancy.side.response.Response;
import com.jobber.vacancy.side.response.factory.AbstractResponseFactory;
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
