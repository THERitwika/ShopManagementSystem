package com.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Product;
import com.project.service.*;


@RestController

public class ProductController {
	@Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getproducts") //get all the existing products
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/addproducts") //add the products
    public Product addProduct(@RequestBody @Valid Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/updateProduct/{id}") //update the existing product details
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/deleteProduct/{id}") //delete the existing product
    public boolean deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
    @PostMapping("/{id}/restock/{quantityToAdd}") //restock the quantity of the existing product
    public Product restockProduct(@PathVariable Long id, @PathVariable int quantityToAdd) {
        return productService.restockProduct(id, quantityToAdd);
    }
}
