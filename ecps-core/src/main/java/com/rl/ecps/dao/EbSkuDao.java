package com.rl.ecps.dao;

import com.rl.ecps.model.EbSku;

import java.util.List;
import java.util.Map;

public interface EbSkuDao {
    public void saveSku(List<EbSku> skuList, Long ItemId);

    public EbSku selectSkuBySkuId(Long skuId);

    public List<EbSku>selectSkuRedis();

    public List<EbSku>selectSkuWithRedisDetail();

    public int updateSkuStock(Map<String,Object> map);
}
