package com.thoughtworks.mstorderservice.shoppingcart;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShoppingCartGoodsRepository extends JpaRepository<ShoppingCartGoods, Long>{
    List<ShoppingCartGoods> findAllByShoppingCartId(Long id);
}
