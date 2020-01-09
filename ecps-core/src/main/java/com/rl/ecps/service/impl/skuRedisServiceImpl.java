package com.rl.ecps.service.impl;

import com.rl.ecps.dao.EbShipAddrDao;
import com.rl.ecps.dao.EbSkuDao;
import com.rl.ecps.model.EbShipAddr;
import com.rl.ecps.model.EbSku;
import com.rl.ecps.model.EbSpecValue;
import com.rl.ecps.service.skuRedisService;
import com.rl.ecps.utils.EcpsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class skuRedisServiceImpl implements skuRedisService {

    @Autowired
    private EbSkuDao skuDao;

    @Autowired
    private EbShipAddrDao shipAddrDao;

    @Override
    public void improtSkuWithRedis() {

        Jedis jedis = new Jedis(EcpsUtils.getPropByKey("redis_host"), new Integer(EcpsUtils.getPropByKey("redis_port")));
        List<EbSku> skuList = skuDao.selectSkuWithRedisDetail();
        for (EbSku sku : skuList) {
            jedis.lpush("skuList:", sku.getSkuId() + "");
            jedis.hset("sku:" + sku.getSkuId(), "skuId", sku.getSkuId() + "");
            jedis.hset("sku:" + sku.getSkuId(), "skuPrice", sku.getSkuPrice() + "");
            jedis.hset("sku:" + sku.getSkuId(), "marketPrice", sku.getMarketPrice() + "");
            jedis.hset("sku:" + sku.getSkuId(), "stockInventory", sku.getStockInventory() + "");
            jedis.hset("sku:" + sku.getSkuId(), "itemId", sku.getItemId() + "");

            jedis.hset("sku:" + sku.getSkuId() + ":item:" + sku.getItem().getItemId(), "itemNo", sku.getItem().getItemNo() + "");
            jedis.hset("sku:" + sku.getSkuId() + ":item:" + sku.getItem().getItemId(), "itemName", sku.getItem().getItemName() + "");
            jedis.hset("sku:" + sku.getSkuId() + ":item:" + sku.getItem().getItemId(), "imgs", sku.getItem().getImgs() + "");
            List<EbSpecValue> specList = sku.getSpecList();
            for (EbSpecValue spec : specList) {
                jedis.lpush("sku:" + sku.getSkuId() + ":specList:", spec.getSpecId() + "");
                jedis.hset("sku:" + sku.getSkuId() + ":spec:" + spec.getSpecId(), "specId", spec.getSpecId() + "");
                jedis.hset("sku:" + sku.getSkuId() + ":spec:" + spec.getSpecId(), "specValue", spec.getSpecValue() + "");
                jedis.hset("sku:" + sku.getSkuId() + ":spec:" + spec.getSpecId(), "skuId", spec.getSkuId() + "");

            }


        }

 /*   @Override
    public void improtSkuWithRedis() {
        //创建对象 hots post
        Jedis jedis = new Jedis(EcpsUtils.getPropByKey("redis_host"),new Integer(EcpsUtils.getPropByKey("redis_port")));
        //同步
        List<EbSku> skuList = skuDao.selectSkuRedis();
        for (EbSku sku:skuList) {
            *//*lpush 存  构造 String key,String...xx 可变长的值*//*
            jedis.lpush("skuList:",sku.getSkuId()+"");
            *//*String key  String file string value*//*
            jedis.hset("sku:"+sku.getSkuId(),"skuId",sku.getSkuId()+"");
            jedis.hset("sku:"+sku.getSkuId(),"skuPrice",sku.getSkuPrice()+"");
            jedis.hset("sku:"+sku.getSkuId(),"marketPrice",sku.getMarketPrice()+"");
            jedis.hset("sku:"+sku.getSkuId(),"stockInventory",sku.getStockInventory()+"");
            jedis.hset("sku:"+sku.getSkuId(),"itemId",sku.getItemId()+"");
            }
        }*/
    }

    @Override
    public void importShipAddrWithRedis() {
        //selectAddressByUserId
        Jedis jedis = new Jedis(EcpsUtils.getPropByKey("redis_host"), new Integer(EcpsUtils.getPropByKey("redis_port")));
        //多对一  我根据1 的一方查询。  所以设计 用户为第一个键 存储他的所有 地址信息
        List<EbShipAddr> addrList = shipAddrDao.selectAddressByUserId(3009L);
        for (EbShipAddr addr : addrList) {

            jedis.lpush("userId:" + "3009"+ ":shipAddrList", addr.getShipAddrId() + "");
            //保存了所有3009用户 的地址id
            jedis.hset("userId:" + "3009" + ":shipAddrId:" + addr.getShipAddrId(), "shipAddrId", addr.getShipAddrId() + "");
            //所有的名字
            jedis.hset("userId:" + "3009" + ":shipAddrId:" + addr.getShipAddrId(), "shipName", addr.getShipName() + "");
            jedis.hset("userId:" + "3009" + ":shipAddrId:" + addr.getShipAddrId(), "province", addr.getProvince() + "");
            jedis.hset("userId:" + "3009" + ":shipAddrId:" + addr.getShipAddrId(), "city", addr.getCity() + "");
            jedis.hset("userId:" + "3009" + ":shipAddrId:" + addr.getShipAddrId(), "district", addr.getDistrict() + "");
            jedis.hset("userId:" + "3009" + ":shipAddrId:" + addr.getShipAddrId(), "zipCode", addr.getZipCode() + "");
            jedis.hset("userId:" + "3009" + ":shipAddrId:" + addr.getShipAddrId(), "addr", addr.getAddr() + "");
            jedis.hset("userId:" + "3009" + ":shipAddrId:" + addr.getShipAddrId(), "phone", addr.getPhone() + "");
            jedis.hset("userId:" + "3009" + ":shipAddrId:" + addr.getShipAddrId(), "defaultAddr", addr.getDefaultAddr() + "");
            jedis.hset("userId:" + "3009" + ":shipAddrId:" + addr.getShipAddrId(), "prevText", addr.getPrevText() + "");
            jedis.hset("userId:" + "3009" + ":shipAddrId:" + addr.getShipAddrId(), "cityText", addr.getCityText() + "");
            jedis.hset("userId:" + "3009" + ":shipAddrId:" + addr.getShipAddrId(), "distText", addr.getDistText() + "");


        }


    }
}