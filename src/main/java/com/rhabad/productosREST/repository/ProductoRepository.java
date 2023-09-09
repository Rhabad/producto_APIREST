package com.rhabad.productosREST.repository;

import com.rhabad.productosREST.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {



}
