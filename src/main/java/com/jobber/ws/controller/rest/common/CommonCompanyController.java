package com.jobber.ws.controller.rest.common;


import com.jobber.ws.service.abstracts.common.CommonCompanyService;
import com.jobber.ws.util.response.factory.AbstractResponseFactory;
import com.jobber.ws.model.filter.concretes.CompanyFilter;
import com.jobber.ws.model.dto.response.company.SimpleCompanyDTO;
import com.jobber.ws.model.dto.response.company.ViewCompanyDTO;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.SimplePageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/1.0/common/company")
@RequiredArgsConstructor
public class CommonCompanyController {

    private final CommonCompanyService companyService;
    private final AbstractResponseFactory<String> abstractResponseFactory;


    @PostMapping("/findAll")
    public ResponseEntity<DataResponse<List<SimpleCompanyDTO>>> findAll(@RequestBody SimplePageable pageable){
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/findByFilter")
    public ResponseEntity<DataResponse<List<SimpleCompanyDTO>>> findAllByFilter(
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


    @PostMapping("/findAllVacancyOfCompany")
    public ResponseEntity<DataResponse<List<SimpleVacancyDTO>>> findAllVacancyOfCompany(
            @RequestParam String companyId,@RequestBody SimplePageable pageable){
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/popularCompanies")
    public ResponseEntity<DataResponse<List<SimpleVacancyDTO>>> findPopularCompanies(@RequestBody SimplePageable pageable){
        return new ResponseEntity<>( HttpStatus.OK);
    }

}
