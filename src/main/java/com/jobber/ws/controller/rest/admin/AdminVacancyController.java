package com.jobber.ws.controller.rest.admin;

import com.jobber.ws.modul.search.filter.VacancyFilter;
import com.jobber.ws.model.dto.request.NewVacancyDTO;
import com.jobber.ws.model.dto.response.user.SimpleWorkerDTO;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.ViewVacancyDTO;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.Response;
import com.jobber.ws.util.response.SimplePageable;
import com.jobber.ws.service.abstracts.admin.AdminVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/1.0/panel/employer/vacancy")
@RequiredArgsConstructor
public class AdminVacancyController {
    private final AdminVacancyService adminVacancyService;

    @PostMapping("/save")
    public ResponseEntity<DataResponse<ViewVacancyDTO>> save(@RequestBody NewVacancyDTO vacancyDTO){
        return new ResponseEntity<>(this.adminVacancyService.save(vacancyDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id){
        return new ResponseEntity<>(this.adminVacancyService.delete(Long.valueOf(id)), HttpStatus.OK);
    }

    //Yalniz istifadecinin oz Elablarini getirmelidi

    @PostMapping("/findAllPageable")
    public ResponseEntity<DataResponse<List<SimpleVacancyDTO>>> findAll(SimplePageable simplePageable){
        return new ResponseEntity<>(this.adminVacancyService.findAll(simplePageable), HttpStatus.OK);
    }

    @PostMapping("/findByFIlter")
    public ResponseEntity<DataResponse<List<SimpleVacancyDTO>>> findByFilter(
            @RequestBody SimplePageable simplePageable,
            @RequestBody VacancyFilter vacancyFilter){
        return new ResponseEntity<>(this.adminVacancyService.findAll(simplePageable), HttpStatus.OK);
    }

    @GetMapping("/open/{id}")
    public ResponseEntity<DataResponse<ViewVacancyDTO>> open(
            @PathVariable(name = "id") String vacancyId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/active/{id}")
    public ResponseEntity<Response> active(
            @PathVariable(name = "id") String vacancyId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/inactive/{id}")
    public ResponseEntity<Response> inActive(
            @PathVariable(name = "id") String vacancyId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/inactive/{id}")
    public ResponseEntity<Response> update(
            @PathVariable(name = "id") String vacancyId){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getEndrolled/{id}")
    public ResponseEntity<DataResponse<List<SimpleWorkerDTO>>> getEnrolled(
            @PathVariable(name = "id") String vacancyId){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
