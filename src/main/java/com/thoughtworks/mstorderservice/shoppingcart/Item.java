package com.thoughtworks.mstorderservice.shoppingcart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Item {
    @JsonProperty("good_id")
    private Long goodsId;

    @JsonProperty
    private int count;

    @Override
    public String toString() {
        return "Item{" +
                "good_id='" + goodsId + '\'' +
                ", count='" + count + '\'' +
                '}';
    }
}
