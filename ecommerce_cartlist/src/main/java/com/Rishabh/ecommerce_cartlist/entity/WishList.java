package com.Rishabh.ecommerce_cartlist.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String product_id;
    @Column
    private String customer_id;
    @Column
    private float product_price;
    @Column
    private LocalDateTime created_on;
    @Column
    private LocalDateTime updated_on;
}
