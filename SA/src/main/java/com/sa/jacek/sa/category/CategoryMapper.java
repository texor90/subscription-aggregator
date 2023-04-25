package com.sa.jacek.sa.category;


import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category mapToEntity(CategoryDto dto);

    CategoryDto mapToDto(Category Category);

    List<CategoryDto> mapToDto(List<Category> Categories);
}
