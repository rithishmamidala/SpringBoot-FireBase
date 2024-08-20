package com.example.firebase.firebase.controller;

import com.example.firebase.firebase.entity.Product;
import com.example.firebase.firebase.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public String saveProduct(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return productService.saveProduct(product);
    }

    @GetMapping("/products/{name}")
    public Product getProduct(@PathVariable String name) throws ExecutionException, InterruptedException{
        return productService.getProduct(name);
    }

    @PutMapping("/products")
    public String update(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{name}")
    public String delete(@PathVariable String name ) throws ExecutionException, InterruptedException
    {
        return productService.deleteProduct(name);
    }



}
