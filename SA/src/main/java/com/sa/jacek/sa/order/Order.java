package com.sa.jacek.sa.order;

import com.sa.jacek.sa.product.Product;
import com.sa.jacek.sa.user.User;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private User user;
    @ManyToOne
    private Product product;
    private LocalDate purchaseDate;


}