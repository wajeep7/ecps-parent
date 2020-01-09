package com.rl.ecps.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.rl.ecps.dao.*;
import com.rl.ecps.model.*;

import com.rl.ecps.sub.EbItemWSService;
import com.rl.ecps.sub.EbItemWSServiceService;
import com.rl.ecps.utils.EcpsUtils;
import com.rl.ecps.utils.Page;
import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.solr.client.solrj.SolrQuery.ORDER;


import com.rl.ecps.service.EbItemService;

@Service
public class EbItemServiceImpl implements EbItemService {

    @Autowired
    private EbItemDao itemDao;


    @Autowired
    private EbItemClodDao ebItemClodDao;


    @Autowired
    private EbPareValueDao pareValueDao;


    @Autowired
    private EbSkuDao skuDao;

    @Autowired
    private EbConsoleLogDao logDao;

    @Override
    public Page selectItemByPage(queryConditon qc) {
        Long tatalCount = itemDao.selectItemCountByQc(qc);
        Page page = new Page();

        page.setPageNo(qc.getPageNo());

        int pageNo = page.getPageNo();
        int pageSize = page.getPageSize();
        page.setTotalCount(tatalCount.intValue());
        int startNum = page.getStartNum();
        int endNum = page.getEndNum();

        qc.setPageNo(pageNo);
        qc.setStartNum(startNum);
        qc.setPageSize(pageSize);
        qc.setEndNum(endNum);

        List<EbItem> list = itemDao.selectItemByQc(qc);
        page.setList(list);
        return page;
    }

    @Override
    public List<EbItem> selectAll() {

        return itemDao.selectAll();
    }

    @Override
    public void saveItem(EbItem item, EbItemClob itemClob, List<EbSku> skuList, List<EbParaValue> pareList) {
        itemDao.saveItem(item);
        ebItemClodDao.saveClodDao(itemClob, item.getItemId());
        pareValueDao.savePareValue(pareList, item.getItemId());
        skuDao.saveSku(skuList, item.getItemId());

    }

    @Override
    public void saveItemConsologUpdate(Long itemId, Short auditStatus, String itemNote) {
        EbItem item = new EbItem();
        item.setItemId(itemId);
        item.setAuditStatus(auditStatus);
        itemDao.updateItem(item);
        //日志信息添加
        EbConsoleLog log = new EbConsoleLog();

        log.setTableName("商品表");
        log.setEntityId(itemId);
        log.setUserId(1L);
        log.setOpType("修改商品审核");
        log.setNotes(itemNote);
        log.setOpTime(new Date());
        log.setEntityName("Eb_Item");
        logDao.save(log);
    }

    @Override
    public void saveItemConsologUpdate1(Long itemId, Short showStatus, String itemNote) {
        EbItem item = new EbItem();
        item.setItemId(itemId);
        item.setShowStatus(showStatus);
        itemDao.updateItem(item);
        //日志信息添加
        EbConsoleLog log = new EbConsoleLog();

        log.setTableName("商品表");
        log.setEntityId(itemId);
        log.setUserId(1L);
        log.setOpType("修改商品状态");
        log.setNotes(itemNote);
        log.setOpTime(new Date());
        log.setEntityName("Eb_Item");
        logDao.save(log);
    }

    @Override
    public List<EbItem> selectItemBySolr(String skuprice, Long brandId, String keyWords, String paraVals) throws Exception {


        List<EbItem> itemList = new ArrayList<EbItem>();
        //链接solr服务器
        SolrServer ss = EcpsUtils.getSolrServer("solr_path");

        //创建solr的查询对象
        SolrQuery sq = new SolrQuery();

        if(StringUtils.isNotBlank(skuprice)) {
            String[] price = skuprice.split("-");
            sq.set("fq", "sku_price:["+price[0]+" TO "+price[1]+"]");
        }


        String queryStr = "*:*";

        if(brandId != null) {
            queryStr = "brand_id:" + brandId;
        }

        if(StringUtils.isNotBlank(keyWords)) {
            if(queryStr.equals("*:*")) {
                queryStr = "item_keywords:"+keyWords;
            }
            else {
                queryStr = queryStr + " AND " + "item_keywords:"+keyWords;
            }
        }

        if(StringUtils.isNotBlank(paraVals)) {
            String[] paraVal = paraVals.split(",");
            String paraValue = "";
            for(String pVal : paraVal) {
                paraValue = paraValue + "para_vals:"+ pVal + " AND ";
            }
            paraValue = paraValue.substring(0, paraValue.lastIndexOf(" AND "));
            if(queryStr.equals("*:*")) {
                queryStr = paraValue;
            }
            else {
                queryStr = queryStr + " AND " + paraValue;
            }
        }

        sq.setQuery(queryStr);   //开始查询

        sq.setSort("id", ORDER.desc);

        //添加高亮
        sq.setHighlight(true);   //开启高亮

        //哪些字段添加高亮
        sq.addHighlightField("item_name");   //名字
        sq.addHighlightField("promotion");   //促销语

        //添加高亮的样式1，前缀， 2.后缀
        sq.setHighlightSimplePre("<font color='red'>");
        sq.setHighlightSimplePost("</font>");


        QueryResponse qr = ss.query(sq);    //通过solr链接服务器进行查询给我一个查询的响应

        SolrDocumentList results = qr.getResults();    //根据响应对象拿到所有的结果集返回一个文档集合对象

        for(SolrDocument sd : results) {
            String itemId = (String) sd.getFieldValue("id");
            String itemName = (String) sd.getFieldValue("item_name");
            String promotion = (String) sd.getFieldValue("promotion");
            String imgs = (String) sd.getFieldValue("imgs");
            String skuPrice1 = sd.getFieldValue("sku_price").toString();

            Map<String, Map<String, List<String>>> hrMap = qr.getHighlighting();
            if(hrMap != null && hrMap.size() > 0) {
                Map<String, List<String>> mapList = hrMap.get(itemId);
                if(mapList != null && mapList.size() > 0) {
                    String hrStr = "";
                    //给哪个字段设置高亮在这里面添加
                    List<String> nlist = mapList.get("item_name");
                    if(nlist != null && nlist.size() > 0) {
                        for(String str : nlist) {
                            hrStr = hrStr + str;
                        }
                        itemName = hrStr;
                    }

                    List<String> prList = mapList.get("promotion");
                    if(prList != null && prList.size() > 0) {
                        for(String str : prList) {
                            hrStr = hrStr + str;
                        }
                        promotion = hrStr;
                    }
                }
            }

            EbItem item = new EbItem();
            item.setItemId(new Long(itemId));
            item.setItemName(itemName);
            item.setPromotion(promotion);
            item.setImgs(imgs);
            item.setSkuprice(new BigDecimal(skuPrice1));
            itemList.add(item);
        }
        return itemList;
    }

    @Override
    public EbItem selectItemDetailByItemId(Long itemId) {

        return itemDao.selectItemDetailByItemId(itemId);
    }

    @Override
    public String publicshItemWs(String password,Long itemId) {
        EbItemWSServiceService ws = new EbItemWSServiceService();
        EbItemWSService wsService = ws.getEbItemWSServicePort();
        return wsService.publiclishService(itemId, password);
    }
}










