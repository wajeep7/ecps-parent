package com.rl.ecps.dao.impl;

import com.rl.ecps.dao.TsPtIUserDao;
import com.rl.ecps.model.TsPtlUser;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class TsPtlUserDaoImpl extends SqlSessionDaoSupport implements TsPtIUserDao {
    private String ns = "com.rl.ecps.mapper.TsPtlUserMapper.";

    @Override
    public TsPtlUser selectLogin(Map<String,Object> map) {
        return this.getSqlSession().selectOne(ns+"selectUserByNameAndPwd",map);
    }
}
