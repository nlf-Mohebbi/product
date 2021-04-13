package com.spring.springexample.modules.module.service;

import com.spring.springexample.modules.module.model.NmModuleModel;
import com.spring.springexample.modules.module.repository.NmModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NmModuleService {
    @Autowired
    NmModuleRepository repository;

    public NmModuleModel getById(Long id){
        NmModuleModel model= repository.findAllById(id);
        if(model!=null){
            return model;
        }
        return new NmModuleModel();
    }

    public NmModuleModel getByTitle(String title){
        NmModuleModel model= repository.findByTitle(title);
        if(model!=null){
            return model;
        }
        return new NmModuleModel();
    }
}
