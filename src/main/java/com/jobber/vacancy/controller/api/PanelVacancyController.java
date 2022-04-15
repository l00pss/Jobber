package com.jobber.vacancy.controller.api;

import com.jobber.vacancy.business.abstracts.PanelVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/1.0/panel/vacancy")
@RequiredArgsConstructor
public class PanelVacancyController {
    private final PanelVacancyService panelVacancyService;
}
