package com.sa.jacek.sa.order;

import com.sa.jacek.sa.exception.IdMismatchException;
import com.sa.jacek.sa.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDto> getAll() {
        return orderMapper.mapToDto(orderRepository.findAll());
    }

    public OrderDto addOrder(OrderDto dto) {
        dto.setPurchaseDate(LocalDate.now());
        Order order = orderMapper.mapToEntity(dto);
        Assert.isNull(order.getId(), "Id has to be null");
        orderRepository.save(order);
        return orderMapper.mapToDto(order);
    }


    public OrderDto getById(Long id) {
        return orderMapper.mapToDto(orderRepository.findById(id).orElse(null));
    }

    public OrderDto updateOrder(Long id, OrderDto dto) {
        Assert.notNull(dto.getId(), "Id cannot be empty");
        if (!dto.getId().equals(id)) {
            throw new IdMismatchException("Id's mismatch");   // porónuje id ze ścieżki z adresu z id w body. Jeśli adresy są tożsame to aktualizacja się wykona.
        }
        if (!orderRepository.existsById(id)) {
            throw new ResourceNotFoundException("Order doesn't exist"); // czy użytkownik do update o podanym id istnieje. bez tego wyjątku zakłada nowego id zamiast aktualizować
        }
        Order entity = orderMapper.mapToEntity(dto);
        orderRepository.save(entity);
        return orderMapper.mapToDto(entity);
    }

    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }
}
