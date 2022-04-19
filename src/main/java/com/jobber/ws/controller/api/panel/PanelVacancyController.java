package com.jobber.ws.controller.api.panel;

import com.jobber.ws.modul.search.filter.VacancyFilter;
import com.jobber.ws.model.dto.request.NewVacancyDTO;
import com.jobber.ws.model.dto.response.user.SimpleWorkerDTO;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.model.dto.response.vacancy.ViewVacancyDTO;
import com.jobber.ws.core.response.DataResponse;
import com.jobber.ws.core.response.Response;
import com.jobber.ws.core.response.SimplePageable;
import com.jobber.ws.business.abstracts.panel.PanelVacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/1.0/panel/vacancy")
@RequiredArgsConstructor
public class PanelVacancyController {
    private final PanelVacancyService panelVacancyService;

    @PostMapping("/save")
    public ResponseEntity<DataResponse<ViewVacancyDTO>> save(@RequestBody NewVacancyDTO vacancyDTO){
        return new ResponseEntity<>(this.panelVacancyService.save(vacancyDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> delete(@PathVariable String id){
        return new ResponseEntity<>(this.panelVacancyService.delete(Long.valueOf(id)), HttpStatus.OK);
    }

    //Yalniz istifadecinin oz Elablarini getirmelidi

    @PostMapping("/findAllPageable")
    public ResponseEntity<DataResponse<List<SimpleVacancyDTO>>> findAll(SimplePageable simplePageable){
        return new ResponseEntity<>(this.panelVacancyService.findAll(simplePageable), HttpStatus.OK);
    }

    @PostMapping("/findByFIlter")
    public ResponseEntity<DataResponse<List<SimpleVacancyDTO>>> findByFilter(
            @RequestBody SimplePageable simplePageable,
            @RequestBody VacancyFilter vacancyFilter){
        return new ResponseEntity<>(this.panelVacancyService.findAll(simplePageable), HttpStatus.OK);
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
