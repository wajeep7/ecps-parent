package com.rl.ecps.controller;

import com.rl.ecps.model.*;
import com.rl.ecps.service.EbBrandService;
import com.rl.ecps.service.EbFeatureService;
import com.rl.ecps.service.EbItemService;
import com.rl.ecps.utils.EcpsUtils;
import com.rl.ecps.utils.Page;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private EbBrandService brandService;

    @Autowired
    private EbItemService itemService;

    @Autowired
    private EbFeatureService ebFeatureService;

    @RequestMapping("/toIndex.do")
    public String toIndex() {
        return "item/index";
    }

    // 跳转到品牌页面/item/ListBrand.do。（listBrand.jsp） 目录在ITEMMENU下

    @RequestMapping("/ListBrand.do")
    public String listBrand(Model model) {
        List<EbBrand> bList = brandService.selectBrandAll();
        model.addAttribute("bList", bList);

        return "item/listbrand";
    }

    @RequestMapping("/toAddBrand.do")
    public String toAddBrand() {
        return "item/addbrand";
    }

    @RequestMapping("/validBrandByNameAjax.do")
    public void validBrandByNameAjax(String brandName, PrintWriter out) {
        List<EbBrand> brand = brandService.selectByName(brandName);
        if (brand.size() >= 1) {
            out.write("no");
        } else {
            out.write("yes");
        }
    }

    @RequestMapping("/addBrand.do")
    public String addBrand(EbBrand brand) {
        brandService.insertBrand(brand);
        // 返回到展示 集合页面
        return "redirect:ListBrand.do";
    }

    @RequestMapping("/toList.do")
    public String toItemList(queryConditon qc, Model model) {
        List<EbBrand> bList = brandService.selectBrandAll();
        model.addAttribute("bList", bList);
        if (qc.getPageNo() == null) {
            qc.setPageNo(1);
        }
        Page page = itemService.selectItemByPage(qc);
        model.addAttribute("page", page);
        model.addAttribute("qc", qc);
        return "item/list";
    }

    @RequestMapping("/toAddItem.do")
    public String toAddItem(Model model) {


        List<EbBrand> bList = brandService.selectBrandAll();
        //普通属性 ==0
        List<EbFeature> fList = ebFeatureService.selectFeaturegeneral();
        //isSpec==1 有规格页面的 feature 集合
        List<EbFeature> specList = ebFeatureService.selectFeatureIsSpec();
        model.addAttribute("specList", specList);

        model.addAttribute("fList", fList);

        model.addAttribute("bList", bList);

        return "item/addItem";
    }


    /**
     * 添加商品最难的
     *
     * @return 核心点 动态数据  商品参数tab 4 的动态数据。
     * 从后台拿 因为之前  是我在后台 传输过去的集合。   由于是,分隔开的多个属性
     * 一定要利用好additem js 也灭的 num 属性。没 新增一个 添加页面div 的num 属性就会++一次 是我在additem js
     * 排除联动关系。 name 赋值时设定的操偶作
     */


    @RequestMapping("/addItem.do")
    public String AddItem(EbItem item, EbItemClob cold, HttpServletRequest request, int divNum) {

        item.setItemNo(System.currentTimeMillis() + "");
        //从数据库拿动态数据
        //普通属性 is.spec==0
        List<EbFeature> fList = ebFeatureService.selectFeaturegeneral();
        //属性PAREVALE 准备接受
        List<EbParaValue> paraList = new ArrayList<EbParaValue>();
        for (EbFeature feature : fList) {
            //拿到前台穿过来的ID
            Long featureId = feature.getFeatureId();
            //拿到前台展示的类型
            Short inputType = feature.getInputType();
            //如果等于3 就是复选框
            if (inputType == 3) {
                //创建对象准备船只
                EbParaValue ebParaValue = new EbParaValue();
                //拿到是复选框的 数组,号分隔后的属性
                String[] parameterValues = request.getParameterValues(featureId + "");
                String newPareValue = "";
                if (parameterValues != null && parameterValues.length > 0) {
                    for (String val : parameterValues) {
                        //给新值加,号 还原成原来的数据
                        newPareValue = newPareValue + val + ",";
                    }
                    //最后一位不要,号

                    newPareValue = newPareValue.substring(0, newPareValue.lastIndexOf(","));


                    /*给对象赋值开始*/

                    ebParaValue.setFeatureId(featureId);
                    ebParaValue.setParaValue(newPareValue);
                    paraList.add(ebParaValue);

                }

            } else {
                // 下拉菜单 和 单选框
                String parameterValues = request.getParameter(featureId + "");
                if (StringUtils.isNotBlank(parameterValues)) {
                    EbParaValue ebParaValue = new EbParaValue();

                    ebParaValue.setFeatureId(featureId);
                    ebParaValue.setParaValue(parameterValues);
                    paraList.add(ebParaValue);

                }
            }
        }


        //创建 库存表集合 给service 层
        List<EbSku> skuList = new ArrayList<EbSku>();
        //ISSPECT 等于1 的规格属性 他查出的信息 =======  skuObj.setSpecList(); ==List<EbSpecValue> specList;
        List<EbFeature> specList = ebFeatureService.selectFeatureIsSpec();


        //tab4 商品规格  围绕divNum 操作
        for (int i = 1; i <= divNum; i++) {
            //sort1  skuPrice1 marketPrice1   stockInventory1   skuUpperLimit1   sku1  location1 showStatus1
            String skuPrice = request.getParameter("skuPrice" + i);
            String stockInventory = request.getParameter("stockInventory" + i);
            //只有当这个 必填选项 商城价格 有值的时候 下面 才有必要进行操作。 如果在前台删除 也不会影响到我
            if (StringUtils.isNotBlank(skuPrice) && StringUtils.isNotBlank(stockInventory)) {

                String sort = request.getParameter("sort" + i);

                String marketPrice = request.getParameter("marketPrice" + i);
                String skuUpperLimit = request.getParameter("skuUpperLimit" + i);
                String sku = request.getParameter("sku" + i);

                String location = request.getParameter("location" + i);
                String showStatus = request.getParameter("showStatus" + i);
                String skuType = request.getParameter("skuType" + i);

                //拿到值 开始赋值商品规格表 sku 前台盘空玩的  商城价 库存 不需要判断
                EbSku skuObj = new EbSku();
                //判空操作


                if (StringUtils.isNotBlank(sort)) {
                    skuObj.setSkuSort(new Integer(sort));
                }
                if (StringUtils.isNotBlank(marketPrice)) {
                    skuObj.setMarketPrice(new BigDecimal(marketPrice));
                }
                if (StringUtils.isNotBlank(skuUpperLimit)) {
                    skuObj.setSkuUpperLimit(new Integer(skuUpperLimit));

                }
                if (StringUtils.isNotBlank(showStatus)) {
                    skuObj.setShowStatus(new Short(showStatus));

                }
                if (StringUtils.isNotBlank(skuType)) {
                    skuObj.setSkuType(new Short(skuType));

                }
                skuObj.setLocation(location);
                skuObj.setSku(sku);
                skuObj.setSkuPrice(new BigDecimal(skuPrice));
                skuObj.setStockInventory(new Integer(stockInventory));

                List<EbSpecValue> specLists = new ArrayList<EbSpecValue>();

                //仓库表 还包含着 对应属性的相关信息 也就是parevalue 的 也就是这个集合   private List<EbSpecValue> specList; 需要拿值
                for (EbFeature feature : specList) {
                    EbSpecValue specValue = new EbSpecValue();
                    String featureValue = request.getParameter(feature.getFeatureId() + "radipspec" + i); //设置和前台一样的格式拿到name 对应的val
                    specValue.setFeatureId(feature.getFeatureId());  //为属性表 的ID 赋值。 isSPEC=1 的属性 对应的ID 和他一样 又在循环里
                    specValue.setSpecValue(featureValue);  //继续添加属性到里面
                    specLists.add(specValue);
                }
                skuObj.setSpecList(specLists);  //一对多关系 添加他的集合 sku 和 spec  sku嵌套 spec 的集合
                skuList.add(skuObj); //仓库表 对象添加对象
                //根据 controller  设置 4表 连接添加接口
            }


        }

        //service 传参
        itemService.saveItem(item, cold, skuList, paraList);


        return "redirect:toList.do?auditStatus=1&showStatus=1";
    }

    /**
     * 跳转商品审核
     *
     * @return
     */
    @RequestMapping("/toListAudit.do")
    public String toListAudit(queryConditon qc, Model model) {
        List<EbBrand> bList = brandService.selectBrandAll();
        model.addAttribute("bList", bList);
        if (qc.getPageNo() == null) {
            qc.setPageNo(1);
        }
        Page page = itemService.selectItemByPage(qc);
        model.addAttribute("page", page);
        model.addAttribute("qc", qc);
        return "item/listAudit";
    }


    //itemNote 意见 审核意见
    @RequestMapping("/listAutidMoidfy.do")
    public String listAutidMoidfy(Long itemId, Short auditStatus, String itemNotes) {

        itemService.saveItemConsologUpdate(itemId, auditStatus, itemNotes);


        return "redirect:toListAudit.do?auditStatus=0";

    }


    @RequestMapping("/listShowModify.do")
    public String listShowModify(Long itemId, Short showStatus, String itemNotes) {
        itemService.saveItemConsologUpdate1(itemId, showStatus, itemNotes);
        return "redirect:toList.do?showStatus=1";

    }


    /**
     * webService 调用
     */
    @RequestMapping("/publishWebService.do")
    public void publishWebService(Long itemId,PrintWriter out){
        String message = itemService.publicshItemWs(EcpsUtils.getPropByKey("web_pass"), itemId);
        /*JSONObject jb = new JSONObject();
        jb.accumulate("message",message);
        String result = jb.toString();
        EcpsUtils.ajaxCommon(result,response);*/

        out.write(message);



    }


}






































