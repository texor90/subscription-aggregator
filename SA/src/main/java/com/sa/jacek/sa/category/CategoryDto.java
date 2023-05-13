package com.sa.jacek.sa.category;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CategoryDto {

    private Long id;
    @NotNull
    @Size(min = 2, max = 30)
    private String name;

}
