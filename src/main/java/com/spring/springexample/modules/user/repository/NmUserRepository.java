package com.spring.springexample.modules.user.repository;

import com.spring.springexample.modules.user.model.NmUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NmUserRepository extends JpaRepository<NmUserModel,Long> {

    NmUserModel findAllById(Long id);
}
