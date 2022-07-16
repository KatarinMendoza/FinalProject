package com.bootcampjava.Finalproject.mapper;

import com.bootcampjava.Finalproject.domain.Customer;
import com.bootcampjava.Finalproject.model.CustomerModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer customerToModel (CustomerModel model);

    CustomerModel customerToModel (Customer customer);

    List<CustomerModel> customersToCustomerModels(List<Customer> customers);

    void update(@MappingTarget Customer entity, CustomerModel model);
}
