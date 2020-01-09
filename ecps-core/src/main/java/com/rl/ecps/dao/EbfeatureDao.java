package com.rl.ecps.dao;

import java.util.List;

import com.rl.ecps.model.EbFeature;

public interface EbfeatureDao {

	/**
	 * 普通的 不是最小单元返回所有属性
	 * 
	 * @return
	 */
	//isspec=0的 没有规格的属性
	public List<EbFeature> selectFeaturegeneral();


	//isspec=1的 有规格属性的  显示商品规格页面的 tab4
	public List<EbFeature>selectFeatureIsSpec();


	//前台开始 是前台 显示的通用属性
	public List<EbFeature>selectFeatureIsSelect();


}
