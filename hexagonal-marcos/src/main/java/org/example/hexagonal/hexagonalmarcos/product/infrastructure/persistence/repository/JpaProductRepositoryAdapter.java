package org.example.hexagonal.hexagonalmarcos.product.infrastructure.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.example.hexagonal.hexagonalmarcos.product.domain.model.Product;
import org.example.hexagonal.hexagonalmarcos.product.domain.ports.out.ProductRepository;
import org.example.hexagonal.hexagonalmarcos.product.infrastructure.persistence.entity.ProductEntity;
import org.example.hexagonal.hexagonalmarcos.product.infrastructure.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JpaProductRepositoryAdapter implements ProductRepository {

    private final JpaProductRepository jpaProductRepository;
    private final ProductMapper productMapper;

    @Override
    public Product save(Product product) {
        ProductEntity entity = productMapper.toEntity(product);
        ProductEntity saved = jpaProductRepository.save(entity);
        return productMapper.toDomain(saved);
    }

    @Override
    public Optional<Product> findById(long id) {
        return jpaProductRepository.findById(id).map(productMapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll()
                .stream()
                .map(productMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        return jpaProductRepository.findById(id).map(existing -> {
            existing.setDescription(product.getDescription());
            existing.setPrice(product.getPrice());
            ProductEntity updated = jpaProductRepository.save(existing);
            return productMapper.toDomain(updated);
        });
    }

    @Override
    public boolean deleteById(long id) {
        if (!jpaProductRepository.existsById(id)) return false;
        jpaProductRepository.deleteById(id);
        return true;
    }
}

