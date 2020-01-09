package com.rl.ecps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rl.ecps.dao.EbBrandDao;
import com.rl.ecps.model.EbBrand;
import com.rl.ecps.service.EbBrandService;

@Service
public class EbBrandServiceImpl implements EbBrandService {
	
	@Autowired
	private EbBrandDao brandDao;
	

	@Override
	public List<EbBrand> selectBrandAll() {
		return brandDao.selectBrandAll();
	}

	@Override
	public void insertBrand(EbBrand brand) {
		brandDao.insertBrand(brand);
	}

	@Override
	public List<EbBrand> selectByName(String brandName) {
		return brandDao.selectByName(brandName);
		
	}

}
