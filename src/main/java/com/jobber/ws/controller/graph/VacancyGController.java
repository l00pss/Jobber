package com.jobber.ws.controller.graph;

import com.jobber.ws.business.abstracts.jobber.JobberVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


public class VacancyGController {
    private JobberVacancyService jobberVacancyService;
}
