package com.thoughtworks.mstorderservice.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    ShoppingCartGoodsRepository shoppingCartGoodsRepository;

    public ShoppingCart create() {
        return shoppingCartRepository.save(new ShoppingCart());
    }

    public void addGoodsToShoppingCart(long shoppingCartId, List<Item> itemList) {
        itemList.forEach(item -> shoppingCartGoodsRepository.save(ShoppingCartGoods.builder()
                                                                                   .shoppingCartId(shoppingCartId)
                                                                                   .goodsId(item.getGoodsId())
                                                                                   .count(item.getCount())
                                                                                   .build()));
    }

    public List<Item> findById(Long id) {
        List<ShoppingCartGoods> shoppingCartGoodsList = shoppingCartGoodsRepository.findAllByShoppingCartId(id);
        return shoppingCartGoodsList.stream()
                             .map(shoppingCartGoods -> Item.builder()
                                                           .goodsId(shoppingCartGoods.getGoodsId())
                                                           .count(shoppingCartGoods.getCount())
                                                           .build())
                             .collect(Collectors.toList());
    }
}
