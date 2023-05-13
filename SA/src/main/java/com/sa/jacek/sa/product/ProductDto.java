package com.sa.jacek.sa.product;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ProductDto {

    private Long id;
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;
    @Size(min = 2, max = 30)
    @NotBlank
    private Long categoryId;
    @NotBlank
    private int durationDays;
    @NotBlank
    @Min(0)
    private double price;

}
