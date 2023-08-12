package com.onlineshoppy.service.impl;

import com.onlineshoppy.dao.ProductCategoryRepository;
import com.onlineshoppy.entity.ProductCategory;
import com.onlineshoppy.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getAllProductCategory() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory getProductCategoryById(Long categoryId) {
        ProductCategory productCategorybyId = productCategoryRepository.findById(categoryId).get();
        if(productCategorybyId!=null){
         return productCategorybyId;
        }
        return null;

    }

    @Override
    public ProductCategory addProductCategory(ProductCategory productCategory) {
        if(productCategory!=null)
        {
           return productCategoryRepository.saveAndFlush(productCategory);
        }
        else
            return null;
    }
}
