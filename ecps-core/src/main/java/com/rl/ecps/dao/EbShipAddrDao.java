package com.rl.ecps.dao;

import com.rl.ecps.model.EbShipAddr;

import java.util.List;

public interface EbShipAddrDao {

    public List<EbShipAddr> selectAddressByUserId(Long userId);


    /**
     * 根据地址表 地址ID 查询用户信息
     */

    public EbShipAddr selectAjaxAddrByAddrId(Long shipAddrId);


    /**
     * 保存用户收货地址信息
     */

    public void saveAddr(EbShipAddr addr);

    /**
     * 修改用户地址信息
     */
    public void updateAddr(EbShipAddr addr);


    public void updateAddr(Long userId);

}
