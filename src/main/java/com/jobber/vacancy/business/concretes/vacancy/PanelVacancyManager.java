package com.jobber.vacancy.business.concretes.vacancy;

import com.jobber.vacancy.business.abstracts.panel.PanelVacancyService;
import com.jobber.vacancy.dataAccess.vacancy.PanelVacancyRepository;
import com.jobber.vacancy.factory.abstracts.AbstractVacancyFactory;
import com.jobber.vacancy.model.dto.request.NewVacancyDTO;
import com.jobber.vacancy.model.dto.response.vacancy.SimpleListVacancyDTO;
import com.jobber.vacancy.model.dto.response.vacancy.ViewVacancyDTO;
import com.jobber.vacancy.model.entity.company.Vacancy;
import com.jobber.vacancy.side.response.DataResponse;
import com.jobber.vacancy.side.response.Response;
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
public class PanelVacancyManager implements PanelVacancyService {
    private final AbstractResponseFactory<ViewVacancyDTO> responseFactory;
    private final AbstractResponseFactory<List<SimpleListVacancyDTO>> responseFactoryAsList;
    private final PanelVacancyRepository panelVacancyRepository;
    private final AbstractVacancyFactory vacancyFactory;

    @Override
    public DataResponse<ViewVacancyDTO> save(NewVacancyDTO vacancyDTO) {
        ViewVacancyDTO vacancy = ViewVacancyDTO
                .factory(this.panelVacancyRepository.save(vacancyFactory.factoryFromSimpleDto(vacancyDTO)));
        return responseFactory.factorySuccessDataResult(vacancy);
    }

    @Override
    public Response delete(Long vacancyId) {
        Vacancy vacancy = panelVacancyRepository.getById(vacancyId);
        vacancy.delete();
        panelVacancyRepository.save(vacancy);
        return responseFactory.factorySuccessResult("Vakansiya uğurla silindi.");
    }


    @Override
    public DataResponse<List<SimpleListVacancyDTO>> findAll() {
        List<SimpleListVacancyDTO> vacancyDTOList =
                panelVacancyRepository
                        .getAllByDeletedFalseAndActiveTrue()
                        .stream()
                        .map(SimpleListVacancyDTO::new)
                        .collect(Collectors.toList());

        return responseFactoryAsList.factorySuccessDataResult(vacancyDTOList,
                "Sorğu üzrə bütün nəticələr");
    }

    @Override
    public DataResponse<List<SimpleListVacancyDTO>> findAll(SimplePageable pageable) {
        List<SimpleListVacancyDTO> vacancyDTOList =
                panelVacancyRepository
                        .findAll(pageable.factory())
                        .getContent()
                        .stream()
                        .filter(Vacancy::isActive)
                        .filter(Predicate.not(Vacancy::isDeleted))
                        .filter(e->e.getExpiredDate().before(new Date()))
                        .map(SimpleListVacancyDTO::new)
                        .collect(Collectors.toList());
        return responseFactoryAsList.factorySuccessDataResult(vacancyDTOList,
                "Sorğu üzrə bütün nəticələr");
    }

    @Override
    public DataResponse<ViewVacancyDTO> open(Long id) {
        ViewVacancyDTO vacancy = ViewVacancyDTO
                .factory(panelVacancyRepository
                .getByIdAndDeletedFalse(id));
        return responseFactory.factorySuccessDataResult(vacancy);
    }
}
