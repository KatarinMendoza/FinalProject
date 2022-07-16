package com.bootcampjava.Finalproject.repositories;

import com.bootcampjava.Finalproject.domain.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsRepository extends JpaRepository<Requests,Long> {
}
