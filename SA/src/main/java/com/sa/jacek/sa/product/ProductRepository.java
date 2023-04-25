package com.sa.jacek.sa.product;

import com.sa.jacek.sa.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
