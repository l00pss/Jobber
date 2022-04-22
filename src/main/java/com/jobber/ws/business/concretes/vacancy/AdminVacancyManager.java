package com.jobber.ws.business.concretes.vacancy;

import com.jobber.ws.business.abstracts.admin.AdminVacancyService;
import com.jobber.ws.dataAccess.vacancy.PanelVacancyRepository;
import com.jobber.ws.model.factory.abstracts.AbstractVacancyFactory;
import com.jobber.ws.model.dto.request.NewVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.ViewVacancyDTO;
import com.jobber.ws.model.entity.company.Vacancy;
import com.jobber.ws.core.response.DataResponse;
import com.jobber.ws.core.response.Response;
import com.jobber.ws.core.response.SimplePageable;
import com.jobber.ws.core.response.factory.AbstractResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminVacancyManager implements AdminVacancyService {
    private final AbstractResponseFactory<ViewVacancyDTO> responseFactory;
    private final AbstractResponseFactory<List<SimpleVacancyDTO>> responseFactoryAsList;
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
    public DataResponse<List<SimpleVacancyDTO>> findAll() {
        List<SimpleVacancyDTO> vacancyDTOList =
                panelVacancyRepository
                        .getAllByDeletedFalseAndActiveTrue()
                        .stream()
                        .map(SimpleVacancyDTO::new)
                        .collect(Collectors.toList());

        return responseFactoryAsList.factorySuccessDataResult(vacancyDTOList,
                "Sorğu üzrə bütün nəticələr");
    }

    @Override
    public DataResponse<List<SimpleVacancyDTO>> findAll(SimplePageable pageable) {
        List<SimpleVacancyDTO> vacancyDTOList =
                panelVacancyRepository
                        .findAll(pageable.factory())
                        .getContent()
                        .stream()
                        .filter(Vacancy::isActive)
                        .filter(Predicate.not(Vacancy::isDeleted))
                        .filter(e->e.getExpiredDate().before(new Date()))
                        .map(SimpleVacancyDTO::new)
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
