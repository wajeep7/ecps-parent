package com.rl.ecps.service;

import java.util.List;

import com.rl.ecps.model.EbFeature;

public interface EbFeatureService {

	/**
	 * 普通的 不是最小单元返回所有属性
	 * isspec =1 的前台没有规格界面显示的
	 * @return
	 */
	public List<EbFeature> selectFeaturegeneral();


	/**
	 * 前台有规格属性的 tab4显示的 isspec==1
	 */

	public List<EbFeature>selectFeatureIsSpec();

	public List<EbFeature> selectFeatureIsSelect();
}
