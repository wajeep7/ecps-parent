package com.rl.ecps.service.impl;

import com.rl.ecps.dao.EbShipAddrDao;
import com.rl.ecps.model.EbShipAddr;
import com.rl.ecps.service.EbShipAddrService;
import com.rl.ecps.utils.EcpsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;


@Service
public class EbShipAddrServiceImpl implements EbShipAddrService {
    @Autowired
    private EbShipAddrDao shipAddrDao;


    @Override
    public List<EbShipAddr> selectAddressByUserId(Long userId) {
        return shipAddrDao.selectAddressByUserId(userId);
    }

    @Override
    public EbShipAddr selectAjaxAddrByAddrId(Long shipAddrId) {
        return shipAddrDao.selectAjaxAddrByAddrId(shipAddrId);
    }

    @Override
    public void saveOrUpdate(EbShipAddr addr) {
        if (addr.getDefaultAddr() == 1) {
            shipAddrDao.updateAddr(addr.getPtlUserId());
        }
        if (addr.getDefaultAddr() == null) {
            shipAddrDao.saveAddr(addr);
        } else {
            shipAddrDao.updateAddr(addr);
        }
    }

    @Override
    public List<EbShipAddr> selectShipAddrByUserIdWithRedis(Long userId) {
        Jedis jedis = new Jedis(EcpsUtils.getPropByKey("redis_host"), new Integer(EcpsUtils.getPropByKey("redis_port")));
        List<String> shipAddrIds = jedis.lrange("userId:" + userId + ":shipAddrList", 0, -1);
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        List<EbShipAddr> addrList = new ArrayList<EbShipAddr>();
        for (String addrId : shipAddrIds) {
            String shipAddrId = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "shipAddrId");
            String shipName = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "shipName");
            String province = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "province");
            String city = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "city");
            String district = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "district");
            String zipCode = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "zipCode");
            String addr = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "addr");
            String phone = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "phone");
            String defaultAddr = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "defaultAddr");
            String prevText = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "prevText");
            String cityText = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "cityText");
            String distText = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "distText");
            EbShipAddr shipAddr = new EbShipAddr();
            shipAddr.setShipAddrId(new Long(shipAddrId));
            shipAddr.setShipName(shipName);
            shipAddr.setProvince(province);
            shipAddr.setCity(city);
            shipAddr.setDistrict(district);
            shipAddr.setZipCode(zipCode);
            shipAddr.setAddr(addr);
            shipAddr.setPhone(phone);
            shipAddr.setDefaultAddr(new Short(defaultAddr));
            shipAddr.setPrevText(prevText);
            shipAddr.setCityText(cityText);
            shipAddr.setDistText(distText);
            addrList.add(shipAddr);
        }


        return addrList;
    }

    @Override
    public EbShipAddr selectShipAddrByUserIdandByShiAddrId(Long userId, Long addrId) {
        Jedis jedis = new Jedis(EcpsUtils.getPropByKey("redis_host"), new Integer(EcpsUtils.getPropByKey("redis_port")));
        String shipAddrId = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "shipAddrId");
        String shipName = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "shipName");
        String province = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "province");
        String city = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "city");
        String district = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "district");
        String zipCode = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "zipCode");
        String addr = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "addr");
        String phone = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "phone");
        String defaultAddr = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "defaultAddr");
        String prevText = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "prevText");
        String cityText = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "cityText");
        String distText = jedis.hget("userId:" + userId + ":shipAddrId:" + addrId, "distText");

        EbShipAddr shipAddr = new EbShipAddr();
        shipAddr.setPtlUserId(userId);
        shipAddr.setShipAddrId(new Long(shipAddrId));
        shipAddr.setShipName(shipName);
        shipAddr.setProvince(province);
        shipAddr.setCity(city);
        shipAddr.setDistrict(district);
        shipAddr.setZipCode(zipCode);
        shipAddr.setAddr(addr);
        shipAddr.setPhone(phone);
        shipAddr.setDefaultAddr(new Short(defaultAddr));
        shipAddr.setPrevText(prevText);
        shipAddr.setCityText(cityText);
        shipAddr.setDistText(distText);


        return shipAddr;
    }


}
