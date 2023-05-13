package com.sa.jacek.sa.order;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDto {


    private Long id;
    @NotNull
    private Long userId;
    @NotNull
    private Long productId;
    private LocalDateTime purchaseDate;

}
