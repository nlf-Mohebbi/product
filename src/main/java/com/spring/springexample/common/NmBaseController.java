package com.spring.springexample.common;

import com.spring.springexample.modules.module.model.NmModuleModel;
import com.spring.springexample.modules.module.service.NmModuleService;
import com.spring.springexample.modules.permission.model.NmPermissionModel;
import com.spring.springexample.modules.permission.service.NmPermissionService;
import com.spring.springexample.modules.user.model.NmUserModel;
import com.spring.springexample.modules.user.service.NmUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class NmBaseController {

    @Autowired
    NmUserService userService;

    @Autowired
    NmPermissionService permissionService;

   @Autowired
    NmModuleService moduleService;

    public NmPermissionModel hasPermission(Long userId, String moduleName){

        NmUserModel userModel= userService.getById(userId);
        NmModuleModel moduleModel=moduleService.getByTitle(moduleName);

        if (userModel!=null){
            NmPermissionModel permissionModel=permissionService.getByGroupId(userModel.getGroupId(),moduleModel.getId());
            return permissionModel;
        }
        return new NmPermissionModel();
    }
}
