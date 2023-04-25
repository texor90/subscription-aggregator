package com.sa.jacek.sa.product;

import com.sa.jacek.sa.user.User;
import com.sa.jacek.sa.user.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface ProductMapper {

    Product mapToEntity(ProductDto dto);

    ProductDto mapToDto(Product Product);

    List<ProductDto> mapToDto(List<Product> Products);
}
