package com.pack.SpringBootJPAIntegration.service;

import java.util.List;

import com.pack.SpringBootJPAIntegration.model.Product;

public interface ProductService {
	Product saveProduct(Product product);



	List<Product> fetchAllProduct();



	void deleteProduct(Integer prod_id);



	Product getProductById(Integer pid);
	Product updateProduct(Product product);
}