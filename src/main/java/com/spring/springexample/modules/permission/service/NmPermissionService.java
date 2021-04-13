package com.spring.springexample.modules.permission.service;

import com.spring.springexample.modules.permission.model.NmPermissionModel;
import com.spring.springexample.modules.permission.repository.NmPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NmPermissionService {

    @Autowired
    NmPermissionRepository repository;

    public NmPermissionModel getByGroupId(Long gId,Long mId){
        NmPermissionModel model=repository.findByGroupIdAndModuleId(gId,mId);
        if(model!=null){
            return model;
        }
        return new NmPermissionModel();
    }
}
