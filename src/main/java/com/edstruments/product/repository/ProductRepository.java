package com.edstruments.product.repository;


import com.edstruments.product.constants.ValidationMessages;
import com.edstruments.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByUuid(String id);

    Optional<Product> findByName(String name);
}
