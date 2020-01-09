package com.rl.ecps.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.rl.ecps.dao.EbfeatureDao;
import com.rl.ecps.model.EbFeature;

@Repository
public class EbFeatureDaoImpl extends SqlSessionDaoSupport implements EbfeatureDao {
    private String ns = "com.rl.ecps.mapper.EbFeatureMapper.";

    @Override
    public List<EbFeature> selectFeaturegeneral() {
        return this.getSqlSession().selectList(ns + "selectFeaturesPuTong");
    }

    @Override
    public List<EbFeature> selectFeatureIsSpec() {
        return this.getSqlSession().selectList(ns + "selectEbFeaturesIsSpec");
    }

    @Override
    public List<EbFeature> selectFeatureIsSelect() {
        return this.getSqlSession().selectList(ns+"selectFeatureIsSelect");

    }

}
