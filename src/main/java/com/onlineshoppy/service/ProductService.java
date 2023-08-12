package com.onlineshoppy.service;

import com.onlineshoppy.entity.Product;
import com.onlineshoppy.entity.ProductCategory;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();

    public Product addProduct(Product product);

    public List<Product> getProductsByCategory(ProductCategory productCategory);

    public List<Product> getProductByName(String productName);

    public Product getProductById(Long productId);
}
