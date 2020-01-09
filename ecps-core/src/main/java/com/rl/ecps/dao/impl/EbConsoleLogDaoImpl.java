package com.rl.ecps.dao.impl;

import com.rl.ecps.dao.EbConsoleLogDao;
import com.rl.ecps.model.EbConsoleLog;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class EbConsoleLogDaoImpl extends SqlSessionDaoSupport implements EbConsoleLogDao {
    private String ns = "com.rl.ecps.mapper.EbConsoleLogMapper.";


    public void save(EbConsoleLog ebConsoleLog) {

        this.getSqlSession().insert(ns+"insert",ebConsoleLog);
    }


}
