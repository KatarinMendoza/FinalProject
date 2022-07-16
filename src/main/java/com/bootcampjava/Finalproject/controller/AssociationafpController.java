package com.bootcampjava.Finalproject.controller;

import com.bootcampjava.Finalproject.domain.Associationafp;
import com.bootcampjava.Finalproject.model.AssociationafpModel;
import com.bootcampjava.Finalproject.service.IAssociationafpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Slf4j
public class AssociationafpController {

    private final IAssociationafpService associationafpService;

    @GetMapping(path = {"associationafp"}, produces = {"application/json"})
    public ResponseEntity<Object> getAll() throws Exception{
        List<AssociationafpModel> response = associationafpService.findAll();
        log.info("getAll" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "associationafp/{id}",produces = {"application/json"})
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) throws Exception{
        AssociationafpModel response = associationafpService.findById(id);
        log.info("getById" + "OK");
        log.debug(id.toString());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping(path = "associationafp")
    public ResponseEntity<Object> create(@RequestBody AssociationafpModel associationafpModel) throws Exception{
        AssociationafpModel response = associationafpService.create(associationafpModel);
        log.info("create" + "OK");
        log.debug(associationafpModel.toString());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping(path = {"associationafp/{id}"}, produces = {"application/json"})
    public void update(
            @PathVariable("id") Long id,
            @RequestBody AssociationafpModel associationafpModel) throws Exception{
        associationafpService.update(id,associationafpModel);
        log.info("update" + "OK");
        log.debug(id.toString() + "/"+ associationafpModel.toString());
    }

    @DeleteMapping({"associationafp/{id}"})
    public void deleteById(@PathVariable("id") Long id) throws Exception{
        associationafpService.deleteById(id);
        log.info("deleteById" + "OK");
        log.debug(id.toString());
    }
}
