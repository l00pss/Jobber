package com.jobber.vacancy.business.concretes;

import com.jobber.vacancy.business.abstracts.PanelVacancyService;
import com.jobber.vacancy.dataAccess.PanelVacancyRepository;
import com.jobber.vacancy.factory.abstracts.AbstractVacancyFactory;
import com.jobber.vacancy.model.dto.request.NewVacancyDTO;
import com.jobber.vacancy.model.dto.response.SimpleListVacancyDTO;
import com.jobber.vacancy.model.entity.Vacancy;
import com.jobber.vacancy.side.response.DataResponse;
import com.jobber.vacancy.side.response.Response;
import com.jobber.vacancy.side.response.factory.AbstractResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PanelVacancyManager implements PanelVacancyService {
    private final AbstractResponseFactory<Vacancy> responseFactory;
    private final AbstractResponseFactory<List<SimpleListVacancyDTO>> responseFactoryAsList;
    private final PanelVacancyRepository panelVacancyRepository;
    private final AbstractVacancyFactory vacancyFactory;

    @Override
    public DataResponse<Vacancy> save(NewVacancyDTO vacancyDTO) {
        return responseFactory.factorySuccessDataResult(
                this.panelVacancyRepository.save(vacancyFactory.factoryFromSimpleDto(vacancyDTO))
        );
    }

    @Override
    public Response delete(Long vacancyId) {
        Vacancy vacancy = panelVacancyRepository.getById(vacancyId);
        vacancy.delete();
        panelVacancyRepository.save(vacancy);
        return responseFactory.factorySuccessResult("Vakansiya uğurla silindi.");
    }
}
