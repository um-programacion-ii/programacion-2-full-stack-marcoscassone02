package org.example.hexagonal.hexagonalmarcos.product.domain.ports.in;

import org.example.hexagonal.hexagonalmarcos.product.domain.model.Product;

import java.util.List;

public interface GetAllProductsUseCase {
    List<Product> getAllProducts();
}
