package com.example.interview.service;

import com.example.interview.model.Product;
import com.example.interview.repository.ProductRepository;
import com.example.interview.util.SecurityUtil;
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

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product addProduct(String name, String price) throws Exception {
        String encryptedPrice = SecurityUtil.encryptPrice(price);
        Product product = new Product(name, encryptedPrice);
        productRepository.save(product);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, String name, String price) throws Exception {
        Optional<Product> result = getProductById(id);

        if (result.isPresent()) {
            if (!name.isEmpty()) {
                result.get().setName(name);
            }

            if (!price.isEmpty()) {
                result.get().setPrice(SecurityUtil.encryptPrice(price));
            }

            return productRepository.save(result.get());
        } else {
            return new Product();
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
