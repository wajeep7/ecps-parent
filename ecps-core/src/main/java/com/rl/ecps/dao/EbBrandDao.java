package com.rl.ecps.dao;

import java.util.List;

import com.rl.ecps.model.EbBrand;



/**
 * 接口
 * @author java
 *
 */
public interface EbBrandDao {
	
	public List<EbBrand> selectBrandAll();
	
	
	public void insertBrand(EbBrand brand);

	
	public List<EbBrand> selectByName(String brandName);


}
