package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Product;
import com.project.repository.*;
@Service
public class ProductService {
    public final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            existingProduct.setPrice(updatedProduct.getPrice());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public boolean deleteProduct(Long id) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            productRepository.delete(existingProduct);
            return true;
        }
        return false;
    }
    public Product restockProduct(Long id, int quantityToAdd) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            int currentQuantity = existingProduct.getQuantity();
            existingProduct.setQuantity(currentQuantity + quantityToAdd);
            return productRepository.save(existingProduct);
        }
        return null;
    }
}