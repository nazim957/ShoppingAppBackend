package com.onlineshoppy.service;

import com.onlineshoppy.entity.Product;
import com.onlineshoppy.entity.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    public List<ProductCategory> getAllProductCategory();

    public ProductCategory getProductCategoryById(Long categoryId);

    public ProductCategory addProductCategory(ProductCategory productCategory);
}
