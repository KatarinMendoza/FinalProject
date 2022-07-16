package com.bootcampjava.Finalproject.service;

import com.bootcampjava.Finalproject.domain.Customer;
import com.bootcampjava.Finalproject.mapper.CustomerMapper;
import com.bootcampjava.Finalproject.model.CustomerModel;
import com.bootcampjava.Finalproject.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService{
    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public List<CustomerModel> findAll() throws Exception {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.customersToCustomerModels(customers);
    }

    @Override
    public CustomerModel findById(Long id) throws Exception {
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) return customerMapper.customerToModel(customer.get());
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public CustomerModel create(CustomerModel customerModel) throws Exception {
        Customer customer= customerRepository.save(customerMapper.customerToModel(customerModel));
        return customerMapper.customerToModel(customer);
    }

    @Override
    public void update(Long id, CustomerModel customerModel) throws Exception {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        if(customerOptional.isPresent()){
            Customer customerToUpdate = customerOptional.get();
            customerMapper.update(customerToUpdate,customerModel);
            customerRepository.save(customerToUpdate);
        }
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public void deleteById(Long id) throws Exception {
        customerRepository.deleteById(id);
    }
}
