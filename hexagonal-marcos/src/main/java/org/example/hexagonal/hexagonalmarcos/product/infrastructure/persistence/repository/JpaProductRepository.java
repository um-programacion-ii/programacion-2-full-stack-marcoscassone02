package org.example.hexagonal.hexagonalmarcos.product.infrastructure.persistence.repository;

import org.example.hexagonal.hexagonalmarcos.product.infrastructure.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
}
