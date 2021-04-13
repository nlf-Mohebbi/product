package com.spring.springexample.modules.group.service;

import com.spring.springexample.modules.group.model.NmGroupModel;
import com.spring.springexample.modules.group.repository.NmGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NmGroupService {
    @Autowired
    NmGroupRepository repository;

    public NmGroupModel getById(Long id){
        NmGroupModel model = repository.findAllById(id);
        if(model!=null){
            return model;
        }
        return new NmGroupModel();
    }
}
