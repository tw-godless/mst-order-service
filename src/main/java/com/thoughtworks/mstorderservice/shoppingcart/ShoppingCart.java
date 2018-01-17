package com.thoughtworks.mstorderservice.shoppingcart;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Setter
@Getter
@Entity(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue
    private Long id;
}
