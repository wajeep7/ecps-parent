package com.rl.ecps.dao.impl;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.rl.ecps.dao.EbItemDao;
import com.rl.ecps.model.EbItem;
import com.rl.ecps.model.queryConditon;

@Repository
public class EbItemDaoImpl extends SqlSessionDaoSupport implements EbItemDao {
	private String ns = "com.rl.ecps.mapper.EbItemMapper.";

	@Override
	public List<EbItem> selectItemByQc(queryConditon qc) {
		return this.getSqlSession().selectList(ns + "selectItemByQc", qc);
	}

	@Override
	public Long selectItemCountByQc(queryConditon qc) {
		return this.getSqlSession().selectOne(ns + "selectItemCountByQc", qc);
	}

	@Override
	public List<EbItem> selectAll() {
		return this.getSqlSession().selectList(ns + "selectAll");
	}

	@Override
	public void saveItem(EbItem Item) {
		this.getSqlSession().insert(ns+"insert",Item);
	}

	@Override
	public void updateItem(EbItem item) {
		this.getSqlSession().update(ns+"updateByPrimaryKeySelective",item);


	}

	@Override
	public void updateItem1(EbItem item) {
		this.getSqlSession().update(ns+"updateByPrimaryKeySelective",item);

	}

	@Override
	public List<EbItem> selectItemByIsSelect() {

		return this.getSqlSession().selectList(ns+"selectItemByIsSelect");
	}

	@Override
	public EbItem selectItemDetailByItemId(Long itemId) {

		return this.getSqlSession().selectOne(ns+"selectItemDetailByItemId",itemId);
	}

}
