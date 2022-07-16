package com.bootcampjava.Finalproject.service;

import com.bootcampjava.Finalproject.model.AffiliationTypeModel;

import java.util.List;

public interface IAffiliationTypeService {

    List<AffiliationTypeModel> findAll() throws Exception;

    AffiliationTypeModel findById(Long id) throws Exception;

    AffiliationTypeModel create(AffiliationTypeModel affiliationTypeModel) throws Exception;

    void update(Long id,AffiliationTypeModel affiliationTypeModel) throws Exception;

    void deleteById(Long id) throws Exception;
}
