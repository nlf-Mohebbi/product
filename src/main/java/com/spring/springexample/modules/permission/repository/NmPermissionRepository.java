package com.spring.springexample.modules.permission.repository;

import com.spring.springexample.modules.permission.model.NmPermissionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NmPermissionRepository extends JpaRepository<NmPermissionModel,Long> {

    NmPermissionModel findByGroupIdAndModuleId(Long groupId,Long moduleId);
}
