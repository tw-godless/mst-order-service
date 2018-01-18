package com.thoughtworks.mstorderservice.shoppingcart;

import com.thoughtworks.mstorderservice.client.GoodsDTO;
import com.thoughtworks.mstorderservice.service.GoodsService;
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

    @Autowired
    GoodsService goodsService;

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

    public List<GoodsDetailDTO> findById(Long id) {
        List<ShoppingCartGoods> shoppingCartGoodsList = shoppingCartGoodsRepository.findAllByShoppingCartId(id);
        return shoppingCartGoodsList.stream()
                                    .map(shoppingCartGoods -> {
                                        GoodsDTO goodsDTO = goodsService.findById(shoppingCartGoods.getGoodsId());
                                        return new GoodsDetailDTO(goodsDTO.getName(),
                                                                  shoppingCartGoods.getGoodsId(),
                                                                  shoppingCartGoods.getCount());
                                    })
                                    .collect(Collectors.toList());
    }
}
