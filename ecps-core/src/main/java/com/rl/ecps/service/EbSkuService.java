package com.rl.ecps.service;

import com.rl.ecps.model.EbSku;

import java.util.Map;

public interface EbSkuService {

    public EbSku selectSkuBySkuId(Long skuId);

    public EbSku selectSkuWithRedis(Long skuId);

    public EbSku selectSkuWithRedisDetail(Long skuId);

    public void updateSkuWithRdisDetail(Map<String,Object> map);

}
