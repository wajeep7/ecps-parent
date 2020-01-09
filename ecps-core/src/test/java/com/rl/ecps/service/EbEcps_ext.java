package com.rl.ecps.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rl.ecps.model.EbSku;
import com.rl.ecps.utils.FMutil;
import com.rl.ecps.utils.MD5;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rl.ecps.model.EbBrand;
import com.rl.ecps.model.EbItem;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml" })
public class EbEcps_ext {
	@Autowired
	private EbBrandService barandService;

	@Autowired
	private EbItemService itemService;

	@Autowired
	private EbFeatureService ebFeatureService;
	@Autowired
	private ImportSolrService importSolrService;

	@Autowired
	private EbSkuService skuService;

	@Autowired
	private skuRedisService redisService;

	@Autowired
	private OrderFlowService orderFlowService;

	@Test
	@Ignore
	public void testSelectBrandAll() {
		List<EbBrand> bList = barandService.selectBrandAll();
		for (EbBrand b : bList) {
			System.out.println(b.getBrandId() + "\t");
			System.out.println(b.getBrandName() + "\t");
			System.out.println(b.getBrandDesc() + "\t");
			System.out.println(b.getBrandSort() + "\t");
			System.out.println(b.getImgs() + "\t");
			System.out.println(b.getWebsite() + "\t");
		}

	}

	@Test
	@Ignore
	public void testInsertBrand() {
		EbBrand brand = new EbBrand();

		brand.setBrandName("萨达阿斯顿");
		brand.setBrandDesc("很a盛d11牛逼");
		brand.setBrandSort(1);
		brand.setImgs("bbb.jpg");
		brand.setWebsite("http//wwww.sanxing.com");
		barandService.insertBrand(brand);
	}

	@Test
	@Ignore
	public void testByName() {
		String brandName = "波导";
		List<EbBrand> byName = barandService.selectByName(brandName);
		for (EbBrand e : byName) {
			System.out.println(e.toString());
		}
	}

	@Test
	@Ignore
	public void testItem() throws Exception {
		Long skuId =3080L;
		EbSku ebSku = skuService.selectSkuBySkuId(skuId);
		System.out.println(ebSku);
	}

	@Test
	//导入SORL
	public void ImprotSorl() throws Exception {
		importSolrService.selectSorlFile();

	}


	@Test
	public void testFreeMarker() throws Exception {
	//静态页面导入
		//3092 3096 3120
		EbItem item = itemService.selectItemDetailByItemId(3096L);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("item",item);
		map.put("path","http://localhost:8020/ecps-protal");
		map.put("upload_file_path","http://localhost:8011/ecps-file");
		FMutil.ouputFile("productDetail.ftl",item.getItemId()+".html",map);

	}


	@Test
	@Ignore
	//密码MD5转换
	public void Md5Print(){
		String md5Code = MD5.GetMD5Code("123456");
		System.out.println(md5Code);
	}


	@Test
	//redis 导入
	public void importRedis(){
		redisService.improtSkuWithRedis();

	}

	@Test
	public void importRedisShipAddrAndUser3009(){

		redisService.importShipAddrWithRedis();
	}

	@Test
	public void oorderFlowServiceTest(){
		orderFlowService.deployInstance();
	}

}
