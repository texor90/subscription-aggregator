package com.sa.jacek.sa.order;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDto {

    private Long id;
    private Long userId;
    private Long productId;
    private LocalDateTime purchaseDate;

}
