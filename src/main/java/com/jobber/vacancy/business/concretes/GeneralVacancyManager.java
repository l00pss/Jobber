package com.jobber.vacancy.business.concretes;

import com.jobber.vacancy.business.abstracts.GeneralVacancyService;
import com.jobber.vacancy.dataAccess.GeneralVacancyRepository;
import com.jobber.vacancy.factory.abstracts.AbstractVacancyFactory;
import com.jobber.vacancy.model.dto.response.SimpleListVacancyDTO;
import com.jobber.vacancy.model.entity.Vacancy;
import com.jobber.vacancy.side.response.DataResponse;
import com.jobber.vacancy.side.response.SimplePageable;
import com.jobber.vacancy.side.response.factory.AbstractResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

    @Override
    public DataResponse<List<SimpleListVacancyDTO>> getAllVacancies() {
        List<SimpleListVacancyDTO> vacancyDTOList =
                generalVacancyRepository
                .getAllByDeletedFalseAndActiveTrue()
                .stream()
                .map(SimpleListVacancyDTO::new)
                .collect(Collectors.toList());

        return responseFactoryAsList.factorySuccessDataResult(vacancyDTOList,
                "Sorğu üzrə bütün nəticələr");
    }

    @Override
    public DataResponse<List<SimpleListVacancyDTO>> getAllVacancies(SimplePageable pageable) {
        List<SimpleListVacancyDTO> vacancyDTOList =
                generalVacancyRepository
                .findAll(pageable.factory())
                .getContent()
                .stream()
                .filter(Vacancy::isActive)
                .filter(Predicate.not(Vacancy::isDeleted))
                .filter(e->e.getDueDate().before(new Date()))
                .map(SimpleListVacancyDTO::new)
                .collect(Collectors.toList());
        return responseFactoryAsList.factorySuccessDataResult(vacancyDTOList,
                "Sorğu üzrə bütün nəticələr");
    }
}
