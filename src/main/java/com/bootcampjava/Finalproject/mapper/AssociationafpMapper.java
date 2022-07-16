package com.bootcampjava.Finalproject.mapper;

import com.bootcampjava.Finalproject.domain.Associationafp;
import com.bootcampjava.Finalproject.model.AssociationafpModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


import java.util.List;

@Mapper(componentModel = "spring")
public interface AssociationafpMapper {

    Associationafp associationafpToModel (AssociationafpModel model);

    AssociationafpModel associationafpToModel (Associationafp associationafp);

    List<AssociationafpModel> associationafpsToAssociationafpModels (List<Associationafp> associationafps);

    void update(@MappingTarget Associationafp entity, AssociationafpModel model);
}
