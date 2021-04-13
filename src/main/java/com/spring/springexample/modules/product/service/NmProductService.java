package com.spring.springexample.modules.product.service;

import com.spring.springexample.common.NmBaseRequestModel;
import com.spring.springexample.common.NmBaseResponse;
import com.spring.springexample.modules.product.model.NmProductModel;
import com.spring.springexample.modules.product.model.NmProductRequest;
import com.spring.springexample.modules.product.model.NmProductResponse;
import com.spring.springexample.modules.product.repository.NmProductRepository;
import net.bytebuddy.TypeCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Service
public class NmProductService {

    @Autowired
    NmProductRepository repository;
    @Autowired
    NmBaseRequestModel requestModel;

    public List<NmProductModel> getAll(Integer pi,Integer ps,String order,String field)
    {
        Sort sort=Sort.by(order=="asc"? Sort.Direction.ASC : Sort.Direction.DESC, field);
        Pageable page= PageRequest.of(pi,ps,sort);
        Page<NmProductModel> models;
        models = repository.findAll(page);

        return models!=null && models.toList().size()>0 ? models.toList():new ArrayList<NmProductModel>();

    }

    public NmProductModel getById(Long id)
    {
        NmProductModel model= repository.findAllById(id);
        if(model!=null){
            return model;
        }
        else{
            return new NmProductModel();
        }
    }

    public NmProductResponse save(NmProductRequest input)
    {
        NmProductResponse response = new NmProductResponse();
        NmProductModel item=new NmProductModel();

        item.isTitleValid(input.getTitle());
        item.isPriceValid(input.getPrice());

        item = repository.findAllByTitle(input.getTitle().trim());
        if (item == null) {
            NmProductModel model = new NmProductModel();
            return fillModelRecord(input, response, model);
        }
        return (NmProductResponse) NmBaseResponse.alreadyExist("This record is already exist! ");
    }

    private NmProductResponse fillModelRecord(NmProductRequest input, NmProductResponse response, NmProductModel model) {
        model.setPrice(input.getPrice());
        model.setModelYear(input.getModelYear());
        model.setCompanyId(input.getCompanyId());
        model.setTitle(input.getTitle());
        model.setCategoryId(input.getCategoryId());

        response.setResult(repository.save(model));
        response = (NmProductResponse) NmBaseResponse.createSuccessfully("Your record saved successfully! ");
        return response;
    }

    public NmProductResponse update(NmProductRequest input)
    {
        NmProductResponse response = new NmProductResponse();
        NmProductModel item=new NmProductModel();

        item.isIdValid(input.getId());
        item.isTitleValid(input.getTitle());
        item.isPriceValid(input.getPrice());

        item = repository.findAllById(input.getId());
        if (item != null) {
            return fillModelRecord(input, response, item);
        }
        return (NmProductResponse) NmBaseResponse.notFound("This record is already exist! ");

    }

    public NmProductResponse delete(Long id) {

        NmProductResponse response=new NmProductResponse();
        NmProductModel model = repository.findAllById(id);
        if (model != null) {
            response=(NmProductResponse) NmBaseResponse.deleteSuccessfully("Your selected record deleted successfully! ");
            repository.delete(model);
            return response;
        } else {
            return (NmProductResponse) NmBaseResponse.notFound("No matched record! ");
        }
    }
}
