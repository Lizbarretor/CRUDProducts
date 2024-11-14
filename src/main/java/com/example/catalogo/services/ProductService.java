package com.example.catalogo.services;

import com.example.catalogo.entities.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    private final List<ProductEntity> products;

    public ProductService() {
        products = new ArrayList<>();
        products.add(new ProductEntity(UUID.randomUUID(), "Laptop", "Electrónica", 1000.00, 50));
        products.add(new ProductEntity(UUID.randomUUID(), "Silla", "Muebles", 150.00, 30));
        products.add(new ProductEntity(UUID.randomUUID(), "Camara", "Fotografia", 500.00, 15));
        products.add(new ProductEntity(UUID.randomUUID(), "Refrigerador", "Electrodomésticos", 1200.00, 10));
        products.add(new ProductEntity(UUID.randomUUID(), "Camisa", "Ropa", 40.00, 100));
        products.add(new ProductEntity(UUID.randomUUID(), "Zapatos", "Calzado", 80.00, 60));
        products.add(new ProductEntity(UUID.randomUUID(), "Escritorio", "Muebles", 200.00, 25));
        products.add(new ProductEntity(UUID.randomUUID(), "Lavadora", "Electrodomésticos", 900.00, 15));
        products.add(new ProductEntity(UUID.randomUUID(), "Reloj", "Accesorios", 150.00, 50));
        products.add(new ProductEntity(UUID.randomUUID(), "Bicicleta", "Deportes", 500.00, 8));
    }

    public List<ProductEntity> createProduct(ProductEntity newProduct) {
        newProduct.setId(UUID.randomUUID());
        products.add(newProduct);
        return (List<ProductEntity>) newProduct;
    }
    public List<ProductEntity> getAllProducts() {
        return products;
    }

    public Optional<ProductEntity> getProductById(UUID id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }

    public Optional<ProductEntity> updateProduct(UUID id, ProductEntity updatedProduct) {
        Optional<ProductEntity> existingProduct = getProductById(id);

        if (existingProduct.isPresent()) {
            ProductEntity product = existingProduct.get();
            product.setProductName(updatedProduct.getProductName());
            product.setCategory(updatedProduct.getCategory());
            product.setPrice(updatedProduct.getPrice());
            product.setStock(updatedProduct.getStock());
            return Optional.of(product);
        }
        return Optional.empty();
    }

    public Optional<ProductEntity> deleteProduct(UUID id) {
        Optional<ProductEntity> productToDelete = getProductById(id);
        productToDelete.ifPresent(products::remove);
        return productToDelete;
    }
}
