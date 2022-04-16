package com.jobber.vacancy.controller.api;

import com.jobber.vacancy.business.abstracts.PanelVacancyService;
import com.jobber.vacancy.model.dto.request.NewVacancyDTO;
import com.jobber.vacancy.model.dto.response.SimpleListVacancyDTO;
import com.jobber.vacancy.model.dto.response.ViewVacancyDTO;
import com.jobber.vacancy.model.entity.Vacancy;
import com.jobber.vacancy.side.response.DataResponse;
import com.jobber.vacancy.side.response.Response;
import com.jobber.vacancy.side.response.SimplePageable;
import lombok.Getter;
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

    @GetMapping("/findAll")
    public ResponseEntity<DataResponse<List<SimpleListVacancyDTO>>> findAll(){
        return new ResponseEntity<>(this.panelVacancyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/findAllPageable")
    public ResponseEntity<DataResponse<List<SimpleListVacancyDTO>>> findAll(SimplePageable simplePageable){
        return new ResponseEntity<>(this.panelVacancyService.findAll(simplePageable), HttpStatus.OK);
    }

    @GetMapping("/open/{id}")
    public ResponseEntity<DataResponse<ViewVacancyDTO>> open(@PathVariable String id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
