package com.Rishabh.ecommerce_cartlist.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "Cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cart_id;
    @Column
    private Long customer_id;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "Cart_id",referencedColumnName = "cart_id")
    private List<CartItem> cartItems;
}
