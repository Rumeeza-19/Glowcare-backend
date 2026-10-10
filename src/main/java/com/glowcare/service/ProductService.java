package com.glowcare.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glowcare.dto.ProductDto;
import com.glowcare.entity.Product;
import com.glowcare.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDto addProduct(ProductDto dto) {

        Product product = new Product();

        product.setName(dto.getName());
        product.setBrand(dto.getBrand());
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setSkinType(dto.getSkinType());
        product.setPrice(dto.getPrice());

        Product savedProduct = productRepository.save(product);

        return convertToDto(savedProduct);
    }

    public List<ProductDto> getAllProducts() {

        List<Product> products = productRepository.findAll();
        List<ProductDto> result = new ArrayList<>();

        for (Product product : products) {
            result.add(convertToDto(product));
        }

        return result;
    }

    public ProductDto getProductById(Long id) {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return null;
        }

        return convertToDto(product);
    }

    public List<ProductDto> searchProducts(String name) {

        List<Product> products =
                productRepository.findByNameContainingIgnoreCase(name);

        List<ProductDto> result = new ArrayList<>();

        for (Product product : products) {
            result.add(convertToDto(product));
        }

        return result;
    }

    public List<ProductDto> getByCategory(String category) {

        List<Product> products =
                productRepository.findByCategory(category);

        List<ProductDto> result = new ArrayList<>();

        for (Product product : products) {
            result.add(convertToDto(product));
        }

        return result;
    }

    public List<ProductDto> getBySkinType(String skinType) {

        List<Product> products =
                productRepository.findBySkinType(skinType);

        List<ProductDto> result = new ArrayList<>();

        for (Product product : products) {
            result.add(convertToDto(product));
        }

        return result;
    }

    public ProductDto updateProduct(Long id, ProductDto dto) {

        Product product = productRepository.findById(id).orElse(null);

        if (product == null) {
            return null;
        }

        product.setName(dto.getName());
        product.setBrand(dto.getBrand());
        product.setCategory(dto.getCategory());
        product.setDescription(dto.getDescription());
        product.setSkinType(dto.getSkinType());
        product.setPrice(dto.getPrice());

        Product updatedProduct = productRepository.save(product);

        return convertToDto(updatedProduct);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private ProductDto convertToDto(Product product) {

        ProductDto dto = new ProductDto();

        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setBrand(product.getBrand());
        dto.setCategory(product.getCategory());
        dto.setDescription(product.getDescription());
        dto.setSkinType(product.getSkinType());
        dto.setPrice(product.getPrice());

        return dto;
    }
}