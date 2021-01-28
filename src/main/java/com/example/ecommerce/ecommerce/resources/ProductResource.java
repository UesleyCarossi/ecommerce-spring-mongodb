package com.example.ecommerce.ecommerce.resources;

import com.example.ecommerce.ecommerce.domain.Product;
import com.example.ecommerce.ecommerce.resources.utils.URL;
import com.example.ecommerce.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> find(@PathVariable Long id) {

        Product product = productService.find(id);

        return ResponseEntity.ok().body(product);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Product>> fingPage(@RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {

        String nameDecoded = URL.decodeParam(name);

        Page<Product> products = productService.search(nameDecoded, page, linesPerPage, orderBy, direction);

        return ResponseEntity.ok().body(products);
    }

}
