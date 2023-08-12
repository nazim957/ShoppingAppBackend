package com.onlineshoppy.service.impl;

import com.onlineshoppy.dao.ProductCategoryRepository;
import com.onlineshoppy.dao.ProductRepository;
import com.onlineshoppy.entity.Product;
import com.onlineshoppy.entity.ProductCategory;
import com.onlineshoppy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        if(productList!=null)
        {
            return productList;
        }
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        if(product!=null) {
            return productRepository.saveAndFlush(product);
        }
        else return null;
    }

    @Override
    public List<Product> getProductsByCategory(ProductCategory productCategory) {
        List<Product> byProductCategory = productRepository.findByProductCategory(productCategory);
        if(!byProductCategory.isEmpty())
        {
            return byProductCategory;
        }
        return null;
    }

    @Override
    public List<Product> getProductByName(String productName) {

        List<Product> byNameContaining = productRepository.findByNameContaining(productName);
        if(byNameContaining!=null)
        {
            return byNameContaining;
        }
        return null;
    }

    @Override
    public Product getProductById(Long productId) {

        Product product = productRepository.findById(productId).get();
        if(product!=null)
        {
            return product;
        }
        return null;
    }

}
