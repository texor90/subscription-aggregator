package com.sa.jacek.sa.product;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")

public interface ProductMapper {

    Product mapToEntity(ProductDto dto);

    ProductDto mapToDto(Product Product);

    List<ProductDto> mapToDto(List<Product> Products);
}
