package com.bootcampjava.Finalproject.service;

import com.bootcampjava.Finalproject.domain.AffiliationType;
import com.bootcampjava.Finalproject.mapper.AffiliationTypeMapper;
import com.bootcampjava.Finalproject.model.AffiliationTypeModel;
import com.bootcampjava.Finalproject.repositories.AffiliationTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AffiliationTypeService implements IAffiliationTypeService{

    private final AffiliationTypeRepository affiliationTypeRepository;

    private final AffiliationTypeMapper affiliationTypeMapper;


    @Override
    public List<AffiliationTypeModel> findAll() throws Exception {
        List<AffiliationType> affiliationTypes = affiliationTypeRepository.findAll();
        return affiliationTypeMapper.affiliationTypesToAffiliationTypeModels(affiliationTypes);
    }

    @Override
    public AffiliationTypeModel findById(Long id) throws Exception {
        Optional<AffiliationType> affiliationType = affiliationTypeRepository.findById(id);
        if (affiliationType.isPresent()) return affiliationTypeMapper.affiliationTypeToModel(affiliationType.get());
        else throw new Exception("No se encontraron Datos");
    }

    @Override
    public AffiliationTypeModel create(AffiliationTypeModel affiliationTypeModel) throws Exception {
        AffiliationType affiliationType=affiliationTypeRepository.save(affiliationTypeMapper.affiliationTypeToModel(affiliationTypeModel));
        return affiliationTypeMapper.affiliationTypeToModel(affiliationType);
    }

    @Override
    public void update(Long id, AffiliationTypeModel affiliationTypeModel) throws Exception {
        Optional<AffiliationType> affiliationTypeOptional = affiliationTypeRepository.findById(id);
        if(affiliationTypeOptional.isPresent()){
            AffiliationType affiliationTypeToUpdate = affiliationTypeOptional.get();
            affiliationTypeMapper.update(affiliationTypeToUpdate,affiliationTypeModel);
        }
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public void deleteById(Long id) throws Exception {
        affiliationTypeRepository.deleteById(id);
    }
}
