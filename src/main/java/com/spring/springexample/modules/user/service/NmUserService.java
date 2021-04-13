package com.spring.springexample.modules.user.service;

import com.spring.springexample.modules.user.model.NmUserModel;
import com.spring.springexample.modules.user.repository.NmUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NmUserService {
    @Autowired
    NmUserRepository repository;

    public NmUserModel getById(Long id){
        NmUserModel model=repository.findAllById(id);
        if(model!=null){
            return model;
        }
        return new NmUserModel();
    }
}
