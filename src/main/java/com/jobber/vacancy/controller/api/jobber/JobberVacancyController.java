package com.jobber.vacancy.controller.api.jobber;

import com.jobber.vacancy.business.abstracts.jobber.JobberVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/1.0/jobber/vacancy")
@RequiredArgsConstructor
public class JobberVacancyController {
    private JobberVacancyService jobberVacancyService;
}
