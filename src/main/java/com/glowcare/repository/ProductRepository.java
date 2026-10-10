package com.glowcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glowcare.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategory(String category);

    List<Product> findBySkinType(String skinType);

    List<Product> findByNameContainingIgnoreCase(String name);
}