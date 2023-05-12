package com.example.quanlykhodemo.demo.repositories;

import com.example.quanlykhodemo.demo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findByTenxe(String tenxe);
    List<Product> findByMaxe(String maxe);
}
