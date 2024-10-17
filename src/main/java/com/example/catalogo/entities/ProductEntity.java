package com.example.catalogo.entities;

import java.util.UUID;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Setter
@Getter
@Data
@NoArgsConstructor

public class ProductEntity {
    private UUID id;
    private String productName;
    private String category;
    private double price;
    private int stock;

    public ProductEntity(UUID id, String productName, String category, double price, int stock) {
        this.id = id;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;

    }


}