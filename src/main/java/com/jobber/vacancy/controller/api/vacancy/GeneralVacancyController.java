package com.jobber.vacancy.controller.api.vacancy;

import com.jobber.vacancy.business.abstracts.vacancy.GeneralVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/1.0/vacancy")
@RequiredArgsConstructor
public class GeneralVacancyController {

    private final GeneralVacancyService generalVacancyService;


}
