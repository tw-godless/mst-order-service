package com.thoughtworks.mstorderservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "mst-goods-service")
public interface GoodsClient {

    @RequestMapping(method = RequestMethod.GET, path = "/api/goods/{goods_id}")
    GoodsDTO getOne(@PathVariable("goods_id") Long goodsId);
}
