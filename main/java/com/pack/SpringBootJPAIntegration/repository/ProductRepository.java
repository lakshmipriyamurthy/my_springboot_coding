package com.pack.SpringBootJPAIntegration.repository;

import org.springframework.data.repository.CrudRepository;

import com.pack.SpringBootJPAIntegration.model.Product;


public interface ProductRepository extends CrudRepository<Product,Integer>{

    Product save(Product product);

}
 