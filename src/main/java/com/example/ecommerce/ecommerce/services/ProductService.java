package com.example.ecommerce.ecommerce.services;

import com.example.ecommerce.ecommerce.domain.Product;
import com.example.ecommerce.ecommerce.repositories.ProductRepository;
import com.example.ecommerce.ecommerce.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product find(Long id) {

        Optional<Product> product = productRepository.findById(id);

        return product.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + " Tipo: " + Product.class.getName()));
    }

    public Page<Product> search(String name, Integer page, Integer linesPerPage, String orderBy, String direction) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        return productRepository.findDistinctByNameContaining(name, pageRequest);
    }

}
