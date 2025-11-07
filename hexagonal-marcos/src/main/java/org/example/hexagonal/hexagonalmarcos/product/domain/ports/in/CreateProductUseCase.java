package org.example.hexagonal.hexagonalmarcos.product.domain.ports.in;

import org.example.hexagonal.hexagonalmarcos.product.domain.model.Product;

public interface CreateProductUseCase {

    Product createProduct(Product product);
}
