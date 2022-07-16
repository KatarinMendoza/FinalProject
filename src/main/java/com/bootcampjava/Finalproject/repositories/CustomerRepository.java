package com.bootcampjava.Finalproject.repositories;

import com.bootcampjava.Finalproject.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
