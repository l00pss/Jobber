package com.jobber.ws.controller.rest.common;

import com.jobber.ws.service.abstracts.common.CommonVacancyService;
import com.jobber.ws.model.filter.concretes.VacancyFilter;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.ViewVacancyDTO;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.SimplePageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/1.0/common/vacancy")
@RequiredArgsConstructor
public class CommonVacancyController {

    private final CommonVacancyService commonVacancyService;

    @PostMapping("/findAll")
    public ResponseEntity<DataResponse<List<SimpleVacancyDTO>>> findAll(@RequestBody SimplePageable pageable){
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/findByFilter")
    public ResponseEntity<DataResponse<List<SimpleVacancyDTO>>> findByFilter(
            @RequestBody SimplePageable pageable,
            @RequestBody VacancyFilter vacancyFilter){
        return new ResponseEntity<>( HttpStatus.OK);
    }


    @GetMapping("/open/{vacancyId}")
    public ResponseEntity<DataResponse<ViewVacancyDTO>> openById(@PathVariable String vacancyId){
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/enroll/{vacancyId}")
    public ResponseEntity<DataResponse<ViewVacancyDTO>> enroll(@PathVariable String vacancyId){
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/show/contact/{vacancyId}")
    public ResponseEntity<DataResponse<ViewVacancyDTO>> showContact(@PathVariable String vacancyId){
        return new ResponseEntity<>( HttpStatus.OK);
    }


}
