package com.Alish.midka.Service;

import com.Alish.midka.model.Address;
import com.Alish.midka.model.Product;
import com.Alish.midka.model.User;
import com.Alish.midka.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(Long id) {
        return productRepository.findById(id);
    }

    public void createProduct(Product product ) {

        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setPrice(product.getPrice());


        productRepository.saveAndFlush(newProduct);

    }

    public void updateProduct(Long id, Product product ) {
        Product productDb = productRepository.findById(id).orElse(null);

        if (productDb != null) {
            productDb.setName(product.getName());
            productDb.setDescription(product.getDescription());
            productDb.setPrice(product.getPrice());
            productRepository.saveAndFlush(productDb);
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


}















