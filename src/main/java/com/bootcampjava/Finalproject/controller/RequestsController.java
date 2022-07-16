package com.bootcampjava.Finalproject.controller;

import com.bootcampjava.Finalproject.domain.Requests;
import com.bootcampjava.Finalproject.model.RequestsModel;
import com.bootcampjava.Finalproject.service.RequestsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Slf4j
public class RequestsController {

    private final RequestsService requestsService;

    @GetMapping(path = {"requests"}, produces = {"application/json"})
    public ResponseEntity<Object> getAll() throws Exception{
        List<RequestsModel> response = requestsService.findAll();
        log.info("getAll" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = {"requests/id"}, produces = {"application/json"})
    public ResponseEntity<Object> getById(@PathVariable("id")Long id) throws Exception{
        RequestsModel response=requestsService.findById(id);
        log.info("getById" + "OK");
        log.debug(id.toString());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping(path = "requests")
    public ResponseEntity<Object> create(@RequestBody RequestsModel requestsModel) throws Exception{
        RequestsModel response = requestsService.create(requestsModel);
        log.info("create" + "OK");
        log.debug(requestsModel.toString());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping(path = {"requests/{id}"},produces = {"application/json"})
    public void update(
            @PathVariable("dni")Long id,
            @RequestBody RequestsModel requestsModel) throws Exception{
        requestsService.update(id,requestsModel);
        log.info("update" + "OK");
        log.debug(id.toString() +"/"+ requestsModel.toString());
    }

    @DeleteMapping({"requests/{id}"})
    public void deleteById(@PathVariable("id")Long id) throws Exception{
        requestsService.deleteById(id);
        log.info("deleteById" + "OK");
        log.debug(id.toString());
    }
}
