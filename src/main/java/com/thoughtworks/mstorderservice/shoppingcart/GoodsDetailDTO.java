package com.thoughtworks.mstorderservice.shoppingcart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class GoodsDetailDTO {
    @JsonProperty("goods_name")
    private String goodsName;

    @JsonProperty("goods_id")
    private Long goodsId;

    @JsonProperty
    private int count;
}
