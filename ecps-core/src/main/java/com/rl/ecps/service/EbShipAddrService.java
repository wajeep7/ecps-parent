package com.rl.ecps.service;

import com.rl.ecps.model.EbShipAddr;

import java.util.List;

public interface EbShipAddrService {

    public List<EbShipAddr> selectAddressByUserId(Long userId);

    EbShipAddr selectAjaxAddrByAddrId(Long shipAddrId);


    public void saveOrUpdate(EbShipAddr addr);

    public List<EbShipAddr>selectShipAddrByUserIdWithRedis(Long userId);


    public EbShipAddr selectShipAddrByUserIdandByShiAddrId(Long userId,Long addrId);

}
