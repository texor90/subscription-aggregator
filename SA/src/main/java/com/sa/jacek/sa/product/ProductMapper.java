package com.sa.jacek.sa.product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ProductMapper {

    @Mapping(source = "categoryId", target = "category.id")

    Product mapToEntity(ProductDto dto);


   @Mapping(source = "category.id", target = "categoryId")
    ProductDto mapToDto(Product product);

    List<ProductDto> mapToDto(List<Product> Products);
}
