package com.jobber.ws.controller.rest.common;

import com.jobber.ws.modul.search.filter.WorkerFilter;
import com.jobber.ws.model.dto.response.user.SimpleWorkerDTO;
import com.jobber.ws.model.dto.response.user.ViewWorkerDTO;
import com.jobber.ws.model.dto.response.vacancy.SimpleVacancyDTO;
import com.jobber.ws.util.response.DataResponse;
import com.jobber.ws.util.response.SimplePageable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/1.0/common/worker")
@RequiredArgsConstructor
public class CommonWorkerController {


    @PostMapping("/findAll")
    public ResponseEntity<DataResponse<List<SimpleWorkerDTO>>> findAll(@RequestBody SimplePageable pageable){
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/findByFilter")
    public ResponseEntity<DataResponse<List<SimpleVacancyDTO>>> findByFilter(
            @RequestBody SimplePageable pageable,
            @RequestBody WorkerFilter workerFilter){
        return new ResponseEntity<>( HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<DataResponse<ViewWorkerDTO>> findById(
            @PathVariable(name = "id") String workerId){
        return new ResponseEntity<>( HttpStatus.OK);
    }


    @GetMapping("/open/{id}")
    public ResponseEntity<DataResponse<ViewWorkerDTO>> openById(
            @PathVariable(name = "id") String workerId){
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
