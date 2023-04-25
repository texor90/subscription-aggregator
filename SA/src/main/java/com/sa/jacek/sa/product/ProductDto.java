package com.sa.jacek.sa.product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private Long categoryId;
    private int durationDays;

}
