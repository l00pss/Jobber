package com.jobber.ws.controller.rest.admin;

import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.factory.AbstractResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/1.0/panel/employer/company")
@RequiredArgsConstructor
public class AdminCompanyController {
    private final AbstractResponseFactory<String> abstractResponseFactory;

    @GetMapping("/findAll")
    public ResponseEntity<DataResponse<String>> findAll(){
        return new ResponseEntity<>( abstractResponseFactory.factorySuccessDataResult(" employer OKEY"), HttpStatus.OK);
    }
}
