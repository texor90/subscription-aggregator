package com.sa.jacek.sa.order;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class OrderDto {

    private Long id;
    private Long user_id;
    private Long product_id;
    private double price;
    private LocalDate purchaseDate;

}
