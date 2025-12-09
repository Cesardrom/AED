package com.docencia.rest.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.docencia.rest.model.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Integer> {

}
