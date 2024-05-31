package com.jtavarez.springbootcrudexamplethymeleafmysql.service;

import com.jtavarez.springbootcrudexamplethymeleafmysql.models.Product;
import com.jtavarez.springbootcrudexamplethymeleafmysql.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
  @Autowired
  private ProductRepository repo;

  public List<Product> listAllProducts() {
    return repo.findAll();
  }
  public Product findProductById(Long id) {
    return repo.findById(id).get();
  }
  public Product saveProduct(Product product) {
    return repo.save(product);
  }
  public Product updateProduct(Product product) {
    return repo.save(product);
  }
  public void deleteProduct(Long id) {
    repo.deleteById(id);
  }
}
