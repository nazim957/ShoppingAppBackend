package com.onlineshoppy.controller;

import com.onlineshoppy.dao.ProductRepository;
import com.onlineshoppy.entity.Product;
import com.onlineshoppy.entity.ProductCategory;
import com.onlineshoppy.service.ProductCategoryService;
import com.onlineshoppy.service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping("/getAllProducts")
    public ResponseEntity<?> getAllProducts()
    {
        List<Product> productList = productService.getAllProducts();
        if(productList!=null)
        {
            return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Product List is Empty", HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/getProductById/{productId}")
    public ResponseEntity<?> getProductById(@PathVariable("productId") Long productId)
    {
        Product productById = productService.getProductById(productId);
        if(productById!=null)
        {
            return new ResponseEntity<>(productById, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Product Id is Not There", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/addProduct/{categoryId}")
    public ResponseEntity<?> addProduct(@PathVariable("categoryId") Long categoryId, @RequestBody Product product)
    {
        ProductCategory productCategoryById = productCategoryService.getProductCategoryById(categoryId);
        product.setProductCategory(productCategoryById);
        Product product1 = productService.addProduct(product);
        if(product1!=null) {
            return new ResponseEntity<>(product1, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("Error in Adding Product",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/getByCategoryId/{categoryId}")
//    public ResponseEntity<?> getyId(@PathVariable("categoryId") Long categoryId)
//    {
//        ProductCategory productCategoryById = productCategoryService.getProductCategoryById(categoryId);
//        if(productCategoryById!=null)
//        {
//            return new ResponseEntity<>(productCategoryById, HttpStatus.OK);
//        }
//        return new ResponseEntity<String>("Product List is Empty", HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @GetMapping("/get/{catId}")
//    public ResponseEntity<?> getProduct(@PathVariable("catId") Long catId)
//    {
//        ProductCategory productById = productCategoryService.getProductCategoryById(catId);
//        productById.getProductSet().c
//    }

    @GetMapping("/getByCategoryId/{categoryId}")
    public ResponseEntity<?> getByCategoryId(@PathVariable("categoryId") Long categoryId) {
        ProductCategory productCategoryById = productCategoryService.getProductCategoryById(categoryId);
        if (productCategoryById != null) {
            List<Product> productsByCategory = productService.getProductsByCategory(productCategoryById);
            if (!productsByCategory.isEmpty()) {
                return new ResponseEntity<>(productsByCategory, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No products found for the specified category", HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>("Product Category not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search/findByNameContaining/{prodName}")
    public ResponseEntity<?> getByName(@PathVariable("prodName") String prodName){
        List<Product> productByName = productService.getProductByName(prodName);
        if(productByName!=null)
        {
            return new ResponseEntity<>(productByName, HttpStatus.OK);
        }
        return new ResponseEntity<>("Product Category not found", HttpStatus.NOT_FOUND);
    }
}
