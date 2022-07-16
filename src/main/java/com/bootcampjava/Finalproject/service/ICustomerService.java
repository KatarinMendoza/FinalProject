package com.bootcampjava.Finalproject.service;

import com.bootcampjava.Finalproject.model.CustomerModel;

import java.util.List;

public interface ICustomerService {

    List<CustomerModel> findAll() throws Exception;

    CustomerModel findById(Long id) throws Exception;

    CustomerModel create(CustomerModel customerModel) throws Exception;

    void update(Long id, CustomerModel customerModel) throws Exception;

    void deleteById(Long id) throws Exception;
}
