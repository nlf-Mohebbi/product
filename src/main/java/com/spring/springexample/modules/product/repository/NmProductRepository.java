package com.spring.springexample.modules.product.repository;

import com.spring.springexample.modules.product.model.NmProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NmProductRepository extends JpaRepository<NmProductModel,Long> {

    Page<NmProductModel> findAll(Pageable page);
    NmProductModel findAllById(Long id);
    NmProductModel findAllByTitle(String title);

}
