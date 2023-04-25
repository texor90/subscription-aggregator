package com.sa.jacek.sa.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getOrder() {
        List<OrderDto> orders = orderService.getAll();
        if (orders.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orders);
        }
    }

    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody @Valid OrderDto Order) {
        OrderDto OrderDto = orderService.addOrder(Order);
        return ResponseEntity.ok(OrderDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder (@PathVariable Long id) {
        OrderDto dto = orderService.getById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody @Valid OrderDto order) {
        OrderDto dto = orderService.updateOrder(id, order);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    // dodatkowe endpointy - wywołanie
    // czy ktokolwiek zakupił dany produkt - wywołanie
    @GetMapping("/anyoneproduct/{productId}")
    public ResponseEntity<Boolean> anyoneBoughtProduct (@PathVariable Long productId) {
        boolean bought = orderService.anyoneBoughtProduct(productId);
        return ResponseEntity.ok(bought);
    }

    // dodatkowe endpointy - wywołanie
    // czy dany użytkownik zakupil konkretny produkt
    @GetMapping("/userproduct/{userId}/{productId}")
    public ResponseEntity<Boolean> userBoughtProduct (@PathVariable Long userId, @PathVariable Long productId) {
        boolean bought = orderService.userBoughtProduct(userId, productId);
        return ResponseEntity.ok(bought);
    }

}