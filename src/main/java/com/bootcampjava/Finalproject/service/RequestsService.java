package com.bootcampjava.Finalproject.service;

import com.bootcampjava.Finalproject.domain.Associationafp;
import com.bootcampjava.Finalproject.domain.Requests;
import com.bootcampjava.Finalproject.mapper.AssociationafpMapper;
import com.bootcampjava.Finalproject.mapper.RequestsMapper;
import com.bootcampjava.Finalproject.model.RequestsModel;
import com.bootcampjava.Finalproject.repositories.AssociationafpRepository;
import com.bootcampjava.Finalproject.repositories.RequestsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestsService implements  IRequestsService{

    private final AssociationafpRepository associationafpRepository;

    private  final AssociationafpMapper associationafpMapper;
    private final RequestsRepository requestsRepository;

    private final RequestsMapper requestsMapper;
    @Override
    public List<RequestsModel> findAll() throws Exception {
        List<Requests> requests = requestsRepository.findAll();
        return requestsMapper.requestsToRequestModels(requests);
    }

    @Override
    public RequestsModel findById(Long id) throws Exception {
        Optional<Requests> reques = requestsRepository.findById(id);
        if(reques.isPresent()) return requestsMapper.requestToModel(reques.get());
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public RequestsModel create(RequestsModel requestsModel) throws Exception {
        //Consulta monto minimo
        Optional<Associationafp> associationafp = associationafpRepository.findById(requestsModel.getCustomer().getId());
        Double MontoMin = associationafp.get().getAmountAvailable() * 0.5;
        if(requestsModel.getAmount() > associationafp.get().getAmountAvailable() ){
            Requests reques = requestsRepository.save(requestsMapper.requestToModel(requestsModel));
            return requestsMapper.requestToModel(reques);
        }else if (requestsModel.getAmount() > MontoMin){
            throw new Exception("No se puede registrar la solicitud. Monto mayor que el permitido ");
        }else throw new Exception("““Monto mínimo no cubierto por favor \n" +
                "revise el monto mínimo a retirar ");

    }

    @Override
    public void update(Long id, RequestsModel requestsModel) throws Exception {
        Optional<Requests> requestsOptional = requestsRepository.findById(id);
        if(requestsOptional.isPresent()){
            Requests requestToUpdate = requestsOptional.get();
            requestsMapper.update(requestToUpdate,requestsModel);
            requestsRepository.save(requestToUpdate);
        }
        else throw new Exception("No se encontraron datos");
    }

    @Override
    public void deleteById(Long id) throws Exception {
        requestsRepository.deleteById(id);
    }
}
