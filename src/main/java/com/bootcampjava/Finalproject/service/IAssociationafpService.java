package com.bootcampjava.Finalproject.service;

import com.bootcampjava.Finalproject.model.AssociationafpModel;

import java.util.List;

public interface IAssociationafpService {

    List<AssociationafpModel> findAll() throws Exception;

    AssociationafpModel findById(Long id) throws Exception;

    AssociationafpModel create(AssociationafpModel associationafpModel) throws Exception;

    void update(Long id,AssociationafpModel associationafpModel) throws Exception;

    void deleteById(Long id) throws Exception;
}
