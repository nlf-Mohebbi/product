package com.spring.springexample.modules.group.repository;

import com.spring.springexample.modules.group.model.NmGroupModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NmGroupRepository extends JpaRepository<NmGroupModel,Long> {
    NmGroupModel findAllById(Long id);
}
