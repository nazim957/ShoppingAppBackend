package com.onlineshoppy.controller;

import com.onlineshoppy.entity.Product;
import com.onlineshoppy.entity.ProductCategory;
import com.onlineshoppy.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/getAllProductsCategory")
    public ResponseEntity<?> getAllProducts()
    {
        List<ProductCategory> productCategoriesList = productCategoryService.getAllProductCategory();
        if(productCategoriesList!=null)
        {
            return new ResponseEntity<>(productCategoriesList, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Product List is Empty", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/getById/{categoryId}")
    public ResponseEntity<?> getAllProductsById(@PathVariable("categoryId") Long categoryId)
    {
        ProductCategory productCategoriesList = productCategoryService.getProductCategoryById(categoryId);
        if(productCategoriesList!=null)
        {
            return new ResponseEntity<>(productCategoriesList, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Product List is Empty", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PostMapping("/addProductCategory")
    public ResponseEntity<?> addCategory(@RequestBody ProductCategory productCategory)
    {
        ProductCategory productCategory1 = productCategoryService.addProductCategory(productCategory);
        if(productCategory1!=null)
        {
            return new ResponseEntity<>(productCategory1,HttpStatus.CREATED);
        }
        else return new ResponseEntity<>("Error in Adding Product Category",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
