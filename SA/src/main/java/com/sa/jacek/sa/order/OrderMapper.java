package com.sa.jacek.sa.order;

import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Order mapToEntity(OrderDto dto);

    OrderDto mapToDto(Order Order);

    List<OrderDto> mapToDto(List<Order> Orders);
}
