package com.jtavarez.springbootcrudexamplethymeleafmysql.repository;

import com.jtavarez.springbootcrudexamplethymeleafmysql.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
