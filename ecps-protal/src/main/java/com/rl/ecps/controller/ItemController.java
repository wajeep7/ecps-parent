package com.rl.ecps.controller;

import java.util.List;

import com.rl.ecps.model.EbSku;
import com.rl.ecps.service.EbSkuService;
import com.rl.ecps.utils.EcpsUtils;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rl.ecps.model.EbBrand;
import com.rl.ecps.model.EbFeature;
import com.rl.ecps.model.EbItem;
import com.rl.ecps.service.EbBrandService;
import com.rl.ecps.service.EbFeatureService;
import com.rl.ecps.service.EbItemService;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/item")
public class ItemController {


    @Autowired
    private EbFeatureService featureService;

    @Autowired
    private EbBrandService brandService;

    @Autowired
    private EbItemService itemService;

    @Autowired
    private EbSkuService skuService;

    @RequestMapping("/toIndex.do")
    public String toIndex(Model model) {
        List<EbBrand> bList = brandService.selectBrandAll();
        model.addAttribute("bList", bList);

        List<EbFeature> fList = featureService.selectFeatureIsSelect();
        model.addAttribute("fList", fList);
        return "index";
    }


    @RequestMapping("/phoneClassification.do")
    public String phoneClassification(String skuprice, Long brandId, String keyWords, String paraVals, Model model) throws Exception {

        List<EbItem> itemList = itemService.selectItemBySolr(skuprice, brandId, keyWords, paraVals);

        model.addAttribute("itemList", itemList);
        return "phoneClassification";
    }

    @RequestMapping("/toProductDetail.do")
    public String productDetail(Long itemId,Model model) {
        EbItem item = itemService.selectItemDetailByItemId(itemId);
        model.addAttribute("item",item);

        return "productDetail";
    }


    /*//orcl 数据库查询
    @RequestMapping("/selectSkuBySkuId.do")
    public void selectSkuBySkuId(HttpServletResponse response,Long skuId){
        EbSku sku = skuService.selectSkuBySkuId(skuId);
        JSONObject jb = new JSONObject();
        jb.accumulate("sku",sku);
        String result = jb.toString();
        EcpsUtils.ajaxCommon(result,response);
    }*/
    @RequestMapping("/selectSkuBySkuId.do")
    public void selectSkuBySkuId(HttpServletResponse response,Long skuId){
        EbSku sku = skuService.selectSkuWithRedis(skuId);
        JSONObject jb = new JSONObject();
        jb.accumulate("sku",sku);
        String result = jb.toString();
        EcpsUtils.ajaxCommon(result,response);
    }


}
