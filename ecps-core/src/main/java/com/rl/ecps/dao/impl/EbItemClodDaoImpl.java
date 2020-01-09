package com.rl.ecps.dao.impl;

import com.rl.ecps.dao.EbItemClodDao;
import com.rl.ecps.model.EbItemClob;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EbItemClodDaoImpl extends SqlSessionDaoSupport implements EbItemClodDao {
    private String ns ="com.rl.ecps.mapper.EbItemClobMapper.";


    @Override
    public void saveClodDao(EbItemClob ebItemClob,Long ItemId) {
            ebItemClob.setItemId(ItemId);//主鍵 拿回 itemID
            this.getSqlSession().insert(ns+"insert",ebItemClob);
    }
}
