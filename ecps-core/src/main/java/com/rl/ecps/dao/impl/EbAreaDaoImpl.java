package com.rl.ecps.dao.impl;

import com.rl.ecps.dao.EbAreaDao;
import com.rl.ecps.model.EbArea;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EbAreaDaoImpl extends SqlSessionDaoSupport implements EbAreaDao {
    private String ns = "com.rl.ecps.mapper.EbAreaMapper.";

    @Override
    public List<EbArea> selectAreaByParentId(Long parentId) {


        return this.getSqlSession().selectList(ns+"selectAreaByParentId",parentId);
    }
}
