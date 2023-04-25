package com.sa.jacek.sa.category;

import com.sa.jacek.sa.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
