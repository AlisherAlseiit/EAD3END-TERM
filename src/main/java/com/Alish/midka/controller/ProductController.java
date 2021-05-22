package com.Alish.midka.controller;

import com.Alish.midka.Service.ProductService;
import com.Alish.midka.model.Product;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Api( tags = "Products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation(value = "This method is used to get the products.")
    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable Long id){
        return productService.getProduct(id);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product){
        productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Long id, @RequestBody Product product){
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }


}
