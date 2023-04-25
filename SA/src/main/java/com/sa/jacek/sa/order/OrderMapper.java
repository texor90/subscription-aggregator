package com.sa.jacek.sa.order;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "productId", target = "product.id")
    Order mapToEntity(OrderDto dto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "product.id", target = "productId")

    OrderDto mapToDto(Order order);

    List<OrderDto> mapToDto(List<Order> orders);
}
