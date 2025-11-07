package org.example.hexagonal.hexagonalmarcos.product.application.service;

import lombok.RequiredArgsConstructor;
import org.example.hexagonal.hexagonalmarcos.product.domain.model.Product;
import org.example.hexagonal.hexagonalmarcos.product.domain.ports.in.CreateProductUseCase;
import org.example.hexagonal.hexagonalmarcos.product.domain.ports.in.GetAllProductsUseCase;
import org.example.hexagonal.hexagonalmarcos.product.domain.ports.out.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements GetAllProductsUseCase, CreateProductUseCase {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }
}
