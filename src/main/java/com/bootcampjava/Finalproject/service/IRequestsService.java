package com.bootcampjava.Finalproject.service;

import com.bootcampjava.Finalproject.model.RequestsModel;

import java.util.List;

public interface IRequestsService {

    List<RequestsModel> findAll() throws Exception;

    RequestsModel findById(Long id) throws Exception;

    RequestsModel create(RequestsModel requestsModel) throws Exception;

    void update(Long id,RequestsModel requestsModel) throws Exception;

    void deleteById(Long dni) throws Exception;
}
