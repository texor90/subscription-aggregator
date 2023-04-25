package com.sa.jacek.sa.order;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class OrderDto {

    private Long id;
    private Long userId;
    private Long productId;
    private double price;
    private LocalDate purchaseDate;

}
