package com.rl.ecps.dao.impl;

import com.rl.ecps.dao.EbShipAddrDao;
import com.rl.ecps.model.EbShipAddr;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EbShipAddrDaoImpl extends SqlSessionDaoSupport implements EbShipAddrDao {
    private String ns = "com.rl.ecps.mapper.EbShipAddrMapper.";



    @Override
    public List<EbShipAddr> selectAddressByUserId(Long userId) {
        return this.getSqlSession().selectList(ns+"selectAddressByUserId",userId);
    }

    @Override
    public EbShipAddr selectAjaxAddrByAddrId(Long shipAddrId) {
        return this.getSqlSession().selectOne(ns+"selectByPrimaryKey",shipAddrId);
    }

    @Override
    public void saveAddr(EbShipAddr addr) {
        this.getSqlSession().insert(ns+"insert",addr);
    }

    @Override
    public void updateAddr(EbShipAddr addr) {
        this.getSqlSession().update(ns+"updateByPrimaryKeySelective",addr);
    }

    @Override
    public void updateAddr(Long userId) {
        this.getSqlSession().update(ns+"updateAddr",userId);
    }


}
