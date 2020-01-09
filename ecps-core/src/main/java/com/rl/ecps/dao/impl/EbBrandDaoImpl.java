package com.rl.ecps.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.rl.ecps.dao.EbBrandDao;
import com.rl.ecps.model.EbBrand;

@Repository
public class EbBrandDaoImpl extends SqlSessionDaoSupport implements EbBrandDao {

	private String ns = "com.rl.ecps.mapper.EbBrandMapper.";

	@Override
	public List<EbBrand> selectBrandAll() {

		return this.getSqlSession().selectList(ns + "selectBrandAll");
	}

	@Override
	public void insertBrand(EbBrand brand) {
		this.getSqlSession().insert(ns + "insert", brand);
	}

	@Override
	public List<EbBrand> selectByName(String brandName) {
		return this.getSqlSession().selectList(ns + "selectByName", brandName);
	}

}
