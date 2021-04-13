package com.spring.springexample.modules.module.repository;

import com.spring.springexample.modules.module.model.NmModuleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NmModuleRepository extends JpaRepository<NmModuleModel,Long> {
    NmModuleModel findAllById(Long id);
    NmModuleModel findByTitle(String title);
}
