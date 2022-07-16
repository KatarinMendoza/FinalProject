package com.bootcampjava.Finalproject.service;

import com.bootcampjava.Finalproject.domain.Associationafp;
import com.bootcampjava.Finalproject.mapper.AssociationafpMapper;
import com.bootcampjava.Finalproject.model.AssociationafpModel;
import com.bootcampjava.Finalproject.repositories.AssociationafpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssociationafpService implements IAssociationafpService{

    private final AssociationafpRepository associationafpRepository;

    private  final AssociationafpMapper associationafpMapper;
    @Override
    public List<AssociationafpModel> findAll() throws Exception {
        List<Associationafp> associationafps = associationafpRepository.findAll();
        return associationafpMapper.associationafpsToAssociationafpModels(associationafps);
    }

    @Override
    public AssociationafpModel findById(Long id) throws Exception {
        Optional<Associationafp> associationafp = associationafpRepository.findById(id);
        if(associationafp.isPresent()) return associationafpMapper.associationafpToModel(associationafp.get());
        else throw new Exception("No se encontraron atos");
    }

    @Override
    public AssociationafpModel create(AssociationafpModel associationafpModel) throws Exception {
         Associationafp associationafp=associationafpRepository.save(associationafpMapper.associationafpToModel(associationafpModel));
       return associationafpMapper.associationafpToModel(associationafp);
    }

    @Override
    public void update(Long id, AssociationafpModel associationafpModel) throws Exception {
        Optional<Associationafp> associationafpOptional = associationafpRepository.findById(id);
        if(associationafpOptional.isPresent()){
            Associationafp associationafpToUpdate = associationafpOptional.get();
            associationafpMapper.update(associationafpToUpdate,associationafpModel);
            associationafpRepository.save(associationafpToUpdate);
        }
        else throw new Exception("No se emcontraron datos");
    }

    @Override
    public void deleteById(Long id) throws Exception {
        associationafpRepository.deleteById(id);
    }
}
