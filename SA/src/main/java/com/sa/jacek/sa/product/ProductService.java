package com.sa.jacek.sa.product;

import com.sa.jacek.sa.exception.IdMismatchException;
import com.sa.jacek.sa.exception.ResourceNotFoundException;
import com.sa.jacek.sa.product.Product;
import com.sa.jacek.sa.product.ProductDto;
import com.sa.jacek.sa.product.ProductMapper;
import com.sa.jacek.sa.product.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDto> getAll() {
        return productMapper.mapToDto(productRepository.findAll());
    }

    public ProductDto addProduct(ProductDto dto) {
        Product Product = productMapper.mapToEntity(dto);
        Assert.isNull(Product.getId(), "Id has to be null");
        productRepository.save(Product);
        return productMapper.mapToDto(Product);
    }


    public ProductDto getById(Long id) {
        return productMapper.mapToDto(productRepository.findById(id).orElse(null));
    }

    public ProductDto updateProduct(Long id, ProductDto dto) {
        Assert.notNull(dto.getId(), "Id cannot be empty");
        if (!dto.getId().equals(id)) {
            throw new IdMismatchException("Id's mismatch");   // porónuje id ze ścieżki z adresu z id w body. Jeśli adresy są tożsame to aktualizacja się wykona.
        }
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Product doesn't exist"); // czy użytkownik do update o podanym id istnieje. bez tego wyjątku zakłada nowego id zamiast aktualizować
        }
        Product entity = productMapper.mapToEntity(dto);
        productRepository.save(entity);
        return productMapper.mapToDto(entity);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
