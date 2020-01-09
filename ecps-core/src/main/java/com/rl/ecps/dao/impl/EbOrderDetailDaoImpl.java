package com.rl.ecps.dao.impl;

import com.rl.ecps.dao.EbOrderDao;
import com.rl.ecps.dao.EbOrderDetailDao;
import com.rl.ecps.model.EbOrder;
import com.rl.ecps.model.EbOrderDetail;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EbOrderDetailDaoImpl extends SqlSessionDaoSupport implements EbOrderDetailDao {
    private String ns="com.rl.ecps.mapper.EbOrderDetailMapper.";

    @Override
    public void saveDetail(EbOrderDetail orderDetail) {
        this.getSqlSession().insert(ns+"insert",orderDetail);
    }
}
