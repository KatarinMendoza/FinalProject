package com.bootcampjava.Finalproject.mapper;

import com.bootcampjava.Finalproject.domain.AffiliationType;
import com.bootcampjava.Finalproject.model.AffiliationTypeModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


import java.util.List;

@Mapper(componentModel = "spring")
public interface AffiliationTypeMapper {

    AffiliationType affiliationTypeToModel(AffiliationTypeModel model);

    AffiliationTypeModel affiliationTypeToModel (AffiliationType affiliationType);

    List<AffiliationTypeModel> affiliationTypesToAffiliationTypeModels(List<AffiliationType> affiliationTypes);

    void update(@MappingTarget AffiliationType entity, AffiliationTypeModel model);
}
