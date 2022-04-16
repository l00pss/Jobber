package com.jobber.ws.controller.api.general;

import com.jobber.ws.business.abstracts.general.GeneralVacancyService;
import com.jobber.ws.model.dto.request.NewVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.ViewVacancyDTO;
import com.jobber.ws.side.response.DataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/1.0/vacancy")
@RequiredArgsConstructor
public class GeneralVacancyController {

    private final GeneralVacancyService generalVacancyService;

    @PostMapping("/save")
    public ResponseEntity<DataResponse<ViewVacancyDTO>> findBy(@RequestBody NewVacancyDTO vacancyDTO){
        return new ResponseEntity<>( HttpStatus.CREATED);
    }


}
