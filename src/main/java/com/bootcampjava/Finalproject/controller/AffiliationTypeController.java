package com.bootcampjava.Finalproject.controller;

import com.bootcampjava.Finalproject.model.AffiliationTypeModel;
import com.bootcampjava.Finalproject.service.IAffiliationTypeService;
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
public class AffiliationTypeController {

    private final IAffiliationTypeService affiliationTypeService;

    @GetMapping(path = {"affiliationType"}, produces = {"application/json"})
    public ResponseEntity<Object> findAll() throws Exception{
        List<AffiliationTypeModel> response= affiliationTypeService.findAll();
        log.info("getAll" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = {"affiliationType/{id}"},produces = {"application/json"})
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) throws Exception{
        AffiliationTypeModel response = affiliationTypeService.findById(id);
        log.info("getById" + "OK");
        log.debug(id.toString());

        return  new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping(path = "affiliationType")
    public ResponseEntity<Object> create(@RequestBody AffiliationTypeModel affiliationTypeModel) throws Exception{
        AffiliationTypeModel response = affiliationTypeService.create(affiliationTypeModel);
        log.info("create" + "OK");
        log.debug(affiliationTypeModel.toString());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping(path = {"affiliationType/{id}"},produces = {"application/json"})
    public void update(
            @PathVariable("id") Long id,
            @RequestBody AffiliationTypeModel affiliationTypeModel) throws Exception{
        affiliationTypeService.update(id,affiliationTypeModel);
        log.info("update" + "OK");
        log.debug(id.toString() + "/"+ affiliationTypeModel.toString());
    }

    @DeleteMapping({"affiliationType/{id}"})
    public void deleteById(@PathVariable("id") Long id) throws Exception{
        affiliationTypeService.deleteById(id);
        log.info("deleteById" + "OK");
        log.debug(id.toString());
    }
}
