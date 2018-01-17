package com.thoughtworks.mstorderservice.shoppingcart;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "shopping_cart_goods")
public class ShoppingCartGoods {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "shopping_cart_id")
    private Long shoppingCartId;

    @Column(name = "goods_id")
    private Long goodsId;

    @Column(name = "count")
    private int count;
}
