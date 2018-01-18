package com.thoughtworks.mstorderservice.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Builder
@Data
@AllArgsConstructor
public class GoodsDTO {
    @JsonProperty("goods_id")
    private Long goodsId;

    @JsonProperty("name")
    private String name;

}
