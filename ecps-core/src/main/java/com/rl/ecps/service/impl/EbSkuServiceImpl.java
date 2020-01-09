package com.rl.ecps.service.impl;

import com.rl.ecps.dao.EbSkuDao;
import com.rl.ecps.model.EbItem;
import com.rl.ecps.model.EbSku;
import com.rl.ecps.model.EbSpecValue;
import com.rl.ecps.service.EbSkuService;
import com.rl.ecps.utils.EcpsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EbSkuServiceImpl implements EbSkuService {
    @Autowired
    private EbSkuDao skuDao;

    @Override
    public EbSku selectSkuBySkuId(Long skuId) {
        return skuDao.selectSkuBySkuId(skuId);
    }

    @Override
    public EbSku selectSkuWithRedis(Long skuId) {

        Jedis jedis = new Jedis(EcpsUtils.getPropByKey("redis_host"), new Integer(EcpsUtils.getPropByKey("redis_port")));

        String skuId1 = jedis.hget("sku:" + skuId, "skuId");
        String skuPrice = jedis.hget("sku:" + skuId, "skuPrice");
        String marketPrice = jedis.hget("sku:" + skuId, "marketPrice");
        String stockInventory = jedis.hget("sku:" + skuId, "stockInventory");
        //String itemId=jedis.hget("sku:"+skuId,"itemId");
        EbSku sku = new EbSku();

        sku.setSkuId(new Long(skuId1.toString()));
        sku.setSkuPrice(new BigDecimal(skuPrice));
        sku.setMarketPrice(new BigDecimal(marketPrice));
        sku.setStockInventory(new Integer(stockInventory));

        return sku;

    }

    @Override
    public EbSku selectSkuWithRedisDetail(Long skuId) {
        Jedis jedis = new Jedis(EcpsUtils.getPropByKey("redis_host"), new Integer(EcpsUtils.getPropByKey("redis_port")));

        String skuId1 = jedis.hget("sku:" + skuId, "skuId");
        String skuPrice = jedis.hget("sku:" + skuId, "skuPrice");
        String marketPrice = jedis.hget("sku:" + skuId, "marketPrice");
        String stockInventory = jedis.hget("sku:" + skuId, "stockInventory");
        String itemId = jedis.hget("sku:" + skuId, "itemId");

        EbSku sku = new EbSku();
        sku.setSkuId(new Long(skuId1));
        sku.setSkuPrice(new BigDecimal(skuPrice));
        sku.setMarketPrice(new BigDecimal(marketPrice));
        sku.setStockInventory(new Integer(stockInventory));
        sku.setItemId(new Long(itemId));
        String itemNo = jedis.hget("sku:" + skuId + ":item:" + itemId, "itemNo");
        String itemName = jedis.hget("sku:" + skuId + ":item:" + itemId, "itemName");
        String imgs = jedis.hget("sku:" + skuId + ":item:" + itemId, "imgs");

        EbItem item = new EbItem();
        item.setItemNo(itemNo);
        item.setImgs(imgs);
        item.setItemName(itemName);
        sku.setItem(item);

        List<String> specValues = jedis.lrange("sku:" + sku.getSkuId() + ":specList:", 0, -1);
        List<EbSpecValue> specValueList = new ArrayList<EbSpecValue>();
        for (String specId : specValues) {
            EbSpecValue spec = new EbSpecValue();
            String specValue = jedis.hget("sku:" + skuId + ":spec:" + specId, "specValue");
            spec.setSpecValue(specValue);
            spec.setSpecId(new Long(specId));
            spec.setSkuId(new Long(skuId));
            specValueList.add(spec);
        }


        sku.setSpecList(specValueList);

        return sku;
    }

    @Override
    public void updateSkuWithRdisDetail(Map<String, Object> map) {
        Jedis jedis = new Jedis(EcpsUtils.getPropByKey("redis_host"), new Integer(EcpsUtils.getPropByKey("redis_port")));
        String skuId = map.get("skuId").toString();
        Integer quantity = (Integer) map.get("quantity");
        jedis.hset("sku:" + skuId, "stockInventory", (new Integer(jedis.hget("sku:" + skuId, "stockInventory")) - quantity) + "");


    }
}
