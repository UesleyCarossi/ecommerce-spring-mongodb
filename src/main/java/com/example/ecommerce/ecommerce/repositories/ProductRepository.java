package com.example.ecommerce.ecommerce.repositories;

import com.example.ecommerce.ecommerce.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ProductRepository extends MongoRepository<Product, Long> {

    @Transactional(readOnly = true)
    Page<Product> findDistinctByNameContaining(@Param("name") String name, Pageable pageRequest);

}
