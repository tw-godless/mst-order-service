package com.thoughtworks.mstorderservice.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping-cart")
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @PostMapping
    public Long create() {
        ShoppingCart shoppingCart = shoppingCartService.create();
        return shoppingCart.getId();
    }

    @PutMapping("/{shopping-cart-id}")
    public void addItems(@PathVariable("shopping-cart-id") long shoppingCartId, @RequestBody List<Item> itemList) {
        shoppingCartService.addGoodsToShoppingCart(shoppingCartId, itemList);
    }

    @GetMapping(path = "/{id}")
    public List<GoodsDetailDTO> findById(@PathVariable("id") Long id) {
        return shoppingCartService.findById(id);
    }
}
