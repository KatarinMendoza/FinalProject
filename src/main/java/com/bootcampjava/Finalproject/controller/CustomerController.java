package com.bootcampjava.Finalproject.controller;

import com.bootcampjava.Finalproject.model.CustomerModel;
import com.bootcampjava.Finalproject.service.ICustomerService;
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
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping(path = {"customer"},produces = {"application/json"})
    public ResponseEntity<Object> getAll()throws Exception{
        List<CustomerModel> response = customerService.findAll();
        log.info("getAll" + "OK");
        log.debug(response.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = { "customer/{id}"},produces = {"application/json"})
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) throws Exception{
        CustomerModel response=customerService.findById(id);
        log.info("getById" + "OK");
        log.debug(id.toString());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping(path = "customer")
    public ResponseEntity<Object> create(@RequestBody CustomerModel customerModel) throws Exception{
        CustomerModel response = customerService.create(customerModel);
        log.info("create" + "OK");
        log.debug(customerModel.toString());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping(path = { "customer/{id}"},produces = {"application/json"})
    public void update(
            @PathVariable("id")Long id,
            @RequestBody CustomerModel customerModel) throws Exception{
        customerService.update(id,customerModel);
        log.info("update" + "OK");
        log.debug(id.toString() + "/" + customerModel.toString());
    }

    @DeleteMapping({"customer/{dni}"})
    public  void deleteById(@PathVariable("id") Long id) throws Exception{
        customerService.deleteById(id);
        log.info("deleteById" + "OK");
        log.debug(id.toString());
    }
}
