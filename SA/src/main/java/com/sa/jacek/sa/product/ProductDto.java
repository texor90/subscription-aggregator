package com.sa.jacek.sa.product;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProductDto {

    @NotBlank
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private Long categoryId;
    @NotBlank
    private int durationDays;
    @NotBlank
    private double price;

}
