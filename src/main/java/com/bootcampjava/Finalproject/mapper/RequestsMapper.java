package com.bootcampjava.Finalproject.mapper;

import com.bootcampjava.Finalproject.domain.Requests;
import com.bootcampjava.Finalproject.model.RequestsModel;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RequestsMapper {

    Requests requestToModel(RequestsModel model);

    RequestsModel requestToModel (Requests request);

    List<RequestsModel> requestsToRequestModels(List<Requests> requests);

    void update(@MappingTarget Requests entity, RequestsModel model);
}
