package com.example.ecommerce.ecommerce.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document(collection = "product")
public class Product {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private Long id;

    private String name;

    private String description;

    private Integer quantity;

    private BigDecimal price;

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", quantity=" + quantity
                + ", price=" + price + "]";
    }

}

/* 

JSON example

{
    "_id": 1,
    "name": "Teste",
    "description": "description",
    "quantity": 1,
    "price": "1",
    "_class": "com.example.ecommerce.ecommerce.domain.Product"
}

*/
