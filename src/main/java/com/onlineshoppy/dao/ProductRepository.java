package com.onlineshoppy.dao;

import com.onlineshoppy.entity.Product;
import com.onlineshoppy.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

//    @Query(value = "select t from product t where t.categoryId= :categoryId")
//    public List<Product> findByProductCategory_Id(Long categoryId);

    List<Product> findByProductCategory(ProductCategory productCategory);

    public List<Product> findByNameContaining(String productName);
}
