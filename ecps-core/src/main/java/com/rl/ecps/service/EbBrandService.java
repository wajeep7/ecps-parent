package com.rl.ecps.service;

import java.util.List;

import com.rl.ecps.model.EbBrand;

public interface EbBrandService {
	public List<EbBrand> selectBrandAll();
	
	
	public void insertBrand(EbBrand brand);
	
	public List<EbBrand> selectByName(String brandName);

}
