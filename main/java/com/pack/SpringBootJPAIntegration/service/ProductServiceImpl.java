package com.pack.SpringBootJPAIntegration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.SpringBootJPAIntegration.model.Product;
import com.pack.SpringBootJPAIntegration.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
@Autowired
private ProductRepository productRepository;
    @Override
    public Product saveProduct(Product product) {
        
        return productRepository.save(product);
    }
    @Override
    public List<Product> fetchAllProduct() {
        List<Product> list=(List<Product>)productRepository.findAll();
        return list;
    }
    @Override
    public void deleteProduct(Integer prod_id) {
        productRepository.deleteById(prod_id);
        
    }
    @Override
    public Product getProductById(Integer pid) {
        Optional<Product> opt=productRepository.findById(pid);
        Product product=opt.get();
        return product;
    }
    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

 
}
