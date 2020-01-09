package com.rl.ecps.dao;

import java.util.List;

import com.rl.ecps.model.EbItem;
import com.rl.ecps.model.queryConditon;

public interface EbItemDao {
/**
 * 模糊查询 返回集合
 * @param qc
 * @return
 */
	public List<EbItem>selectItemByQc(queryConditon qc);
	
	
	
	
	/**
	 * 模糊查询返回总数据量
	 */
	
	public Long selectItemCountByQc(queryConditon qc);
	
	/**
	 * 测试
	 */
	public List <EbItem> selectAll();

	public void saveItem(EbItem Item);

	public void updateItem(EbItem item);
	public void updateItem1(EbItem item);

	public List<EbItem>selectItemByIsSelect();

	public EbItem selectItemDetailByItemId(Long itemId);


}
