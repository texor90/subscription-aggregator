package com.sa.jacek.sa.product;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductDto {

    private Long id;
    private String name;
    private String category;
    private double price;
    private int durationDays;

}
