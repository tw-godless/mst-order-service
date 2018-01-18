package com.thoughtworks.mstorderservice.service;

import com.thoughtworks.mstorderservice.client.GoodsClient;
import com.thoughtworks.mstorderservice.client.GoodsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsService {
    @Autowired
    GoodsClient goodsClient;


    public GoodsDTO findById(Long goodsId) {
        return goodsClient.getOne(goodsId);
    }
}
