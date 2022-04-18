package com.jobber.ws.controller.api.common;


import com.jobber.ws.business.abstracts.common.CommonCompanyService;
import com.jobber.ws.business.search.filter.CompanyFilter;
import com.jobber.ws.model.dto.response.company.SimpleCompanyDTO;
import com.jobber.ws.model.dto.response.company.ViewCompanyDTO;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.core.response.DataResponse;
import com.jobber.ws.core.response.SimplePageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/1.0/company")
@RequiredArgsConstructor
public class CommonCompanyController {

    private final CommonCompanyService companyService;

    @PostMapping("/findAll")
    public ResponseEntity<DataResponse<List<SimpleCompanyDTO>>> findAll(@RequestBody SimplePageable pageable){
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/findByFilter")
    public ResponseEntity<DataResponse<List<SimpleCompanyDTO>>> findByFilter(
            @RequestBody SimplePageable pageable,
            @RequestBody CompanyFilter vacancyFilter){
        return new ResponseEntity<>( HttpStatus.OK);
    }


    @GetMapping("/open/{id}")
    public ResponseEntity<DataResponse<ViewCompanyDTO>> openById(
            @PathVariable(name = "id") String companyId){
        return new ResponseEntity<>( HttpStatus.OK);
    }


    @GetMapping("/show/contact/{id}")
    public ResponseEntity<DataResponse<ViewCompanyDTO>> showContact(
            @PathVariable(name = "id") String companyId){
        return new ResponseEntity<>( HttpStatus.OK);
    }


    @GetMapping("/findAllVacancy/{id}")
    public ResponseEntity<DataResponse<List<SimpleVacancyDTO>>> findAllVacancy(
            @PathVariable(name = "id") String companyId){
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/popularCompanies")
    public ResponseEntity<DataResponse<List<SimpleVacancyDTO>>> findPopularCompanies(){
        return new ResponseEntity<>( HttpStatus.OK);
    }



}
