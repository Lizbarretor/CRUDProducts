package com.example.catalogo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.catalogo.entities.ProductEntity;
import com.example.catalogo.services.ProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    //method to get ALL products
    @GetMapping
    public List<ProductEntity> getProducts(){
        return productService.getAllProducts();
    }

    //Method to get one product by ID
    @GetMapping("/{id}")
    public Optional<ProductEntity> getProducts(@PathVariable UUID id){
        return productService.getProductById(id);
    }

    //Method to create one product
    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity product){
        return (ProductEntity) productService.createProduct(product);
    }


    //Method to update one product
    @PutMapping("/{id}")
    public Optional<ProductEntity> updateProduct(@PathVariable UUID id, @RequestBody ProductEntity product) {
        return productService.updateProduct(id, product);
    }

    //Method to delete one product
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable UUID id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return "Product deleted successfully";
        } else {
            return "Product not found";
        }
    }

}
