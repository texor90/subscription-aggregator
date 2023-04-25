package com.sa.jacek.sa.category;

import com.sa.jacek.sa.exception.IdMismatchException;
import com.sa.jacek.sa.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDto> getAll() {
        return categoryMapper.mapToDto(categoryRepository.findAll());
    }

    public CategoryDto addCategory (CategoryDto dto) {
        Category Category = categoryMapper.mapToEntity(dto);
        Assert.isNull(Category.getId(), "Id has to be null");
        categoryRepository.save(Category);
        return categoryMapper.mapToDto(Category);
    }

    public CategoryDto getById(Long id) {
        return categoryMapper.mapToDto(categoryRepository.findById(id).orElse(null));
    }

    public CategoryDto updateCategory (Long id, CategoryDto dto) {
        Assert.notNull(dto.getId(), "Id cannot be empty");
        if (!dto.getId().equals(id)) {
            throw new IdMismatchException("Id's mismatch");   // porónuje id ze ścieżki z adresu z id w body. Jeśli adresy są tożsame to aktualizacja się wykona.
        }
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category doesn't exist"); // czy użytkownik do update o podanym id istnieje. bez tego wyjątku zakłada nowego id zamiast aktualizować
        }
        Category entity = categoryMapper.mapToEntity(dto);
        categoryRepository.save(entity);
        return categoryMapper.mapToDto(entity);
    }

    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
