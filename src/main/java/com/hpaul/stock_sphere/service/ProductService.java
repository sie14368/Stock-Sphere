package com.hpaul.stock_sphere.service;

import com.hpaul.stock_sphere.entity.Product;
import com.hpaul.stock_sphere.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Add Product
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get All Products
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get Product By ID
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    // Update Product
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productRepository.findById(id).orElse(null);

        if (product != null) {
            product.setProductName(updatedProduct.getProductName());
            product.setDescription(updatedProduct.getDescription());
            product.setCurrentStock(updatedProduct.getCurrentStock());

            return productRepository.save(product);
        }

        return null;
    }

    // Delete Product
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}