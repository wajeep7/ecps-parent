package com.rl.ecps.service;

import java.util.List;

import com.rl.ecps.model.*;
import com.rl.ecps.utils.Page;

public interface EbItemService {

	public Page selectItemByPage(queryConditon qc);
	
	public List <EbItem> selectAll();

	/**
	 * 多表添加部分
	 */
	public void saveItem(EbItem item, EbItemClob itemClob,List<EbSku>skuList,List<EbParaValue>pareList);


	public void saveItemConsologUpdate(Long itemId ,Short auditStatus,String itemNote);
	public void saveItemConsologUpdate1(Long itemId ,Short showStatus,String itemNote);

	public List<EbItem> selectItemBySolr(String skuprice, Long brandId, String keyWords, String paraVals) throws Exception;

	public EbItem selectItemDetailByItemId(Long itemId);


	public String publicshItemWs(String password,Long itemId);

}
