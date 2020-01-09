package com.rl.ecps.dao.impl;

import com.rl.ecps.dao.EbPareValueDao;
import com.rl.ecps.model.EbParaValue;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EbPareValueDaoImpl extends SqlSessionDaoSupport implements EbPareValueDao {
    private String ns = "com.rl.ecps.mapper.EbParaValueMapper.";

    @Override
    public void savePareValue(List<EbParaValue> ParaList, Long itemId) {
    //in 添加session 放在外邊
        SqlSession sqlSession = this.getSqlSession();
        for (EbParaValue paraValue:ParaList){
            paraValue.setItemId(itemId);
            sqlSession.insert(ns+"insert",paraValue);
        }
    }
}
