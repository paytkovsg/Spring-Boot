package ru.gd.springbootapp.service;

import org.springframework.stereotype.Service;
import ru.gd.springbootapp.dto.Product;
import ru.gd.springbootapp.repository.ProductRepository;


import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public void saveProduct(Product product){
        productRepository.saveProduct(product);
    }

    public Product findById(int id){
        return productRepository.findById(id);

    }
    public void deleteById(int id){
        productRepository.deleteFindById(id);
    }


}
