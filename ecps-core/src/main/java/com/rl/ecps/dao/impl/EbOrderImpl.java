package com.rl.ecps.dao.impl;

import com.rl.ecps.dao.EbOrderDao;
import com.rl.ecps.model.EbOrder;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EbOrderImpl extends SqlSessionDaoSupport implements EbOrderDao {
    private String ns="com.rl.ecps.mapper.EbOrderMapper.";



    @Override
    public void saveOrder(EbOrder order) {
        this.getSqlSession().insert(ns+"insert",order);

    }

    @Override
    public void updateOrder(EbOrder order) {
        this.getSqlSession().update(ns+"updateByPrimaryKeySelective",order);
    }

    @Override
    public EbOrder selectByOrderId(Long orderId) {
        return this.getSqlSession().selectOne(ns+"selectByPrimaryKey",orderId);
    }

    @Override
    public EbOrder selectOrderDetialById(Long orderId) {
        return this.getSqlSession().selectOne(ns+"selectOrderDetialById",orderId);
    }
}
