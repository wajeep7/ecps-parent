package com.rl.ecps.dao.impl;

import com.rl.ecps.dao.EbSkuDao;
import com.rl.ecps.model.EbSku;
import com.rl.ecps.model.EbSpecValue;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EbSkuDaoImpl extends SqlSessionDaoSupport implements EbSkuDao {
    private String ns="com.rl.ecps.mapper.EbSkuMapper.";

    private String ns1="com.rl.ecps.mapper.EbSpecValueMapper.";
    @Override
    public void saveSku(List<EbSku> skuList, Long ItemId) {
        SqlSession sqlSession = this.getSqlSession();
        for (EbSku sku:skuList) {
            sku.setItemId(ItemId);
            sqlSession.insert(ns+"insert",sku);
            List<EbSpecValue> specList = sku.getSpecList();
            for (EbSpecValue specValue:specList) {
                specValue.setSkuId(sku.getSkuId());
                sqlSession.insert(ns1+"insert",specValue);
            }
        }


    }

    @Override
    public EbSku selectSkuBySkuId(Long skuId) {

        return this.getSqlSession().selectOne(ns+"selectByPrimaryKey",skuId);
    }

    @Override
    public List<EbSku> selectSkuRedis() {
        return this.getSqlSession().selectList(ns+"selectSkuRedis");
    }

    @Override
    public List<EbSku> selectSkuWithRedisDetail() {

        return this.getSqlSession().selectList(ns+"selectSkuWithRedisDetail");
    }

    @Override
    public int updateSkuStock(Map<String, Object> map) {

        return this.getSqlSession().update(ns+"skuUpdateStock",map);
    }
}
