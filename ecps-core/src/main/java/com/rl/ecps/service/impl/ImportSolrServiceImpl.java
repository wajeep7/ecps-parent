package com.rl.ecps.service.impl;

import java.util.List;

import com.rl.ecps.utils.EcpsUtils;
import org.apache.solr.client.solrj.SolrServer;

import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rl.ecps.dao.EbItemDao;
import com.rl.ecps.model.EbItem;
import com.rl.ecps.model.EbParaValue;
import com.rl.ecps.service.ImportSolrService;

@Service
public class ImportSolrServiceImpl implements ImportSolrService {

    @Autowired
    private EbItemDao itemDao;

    @Override
    public void selectSorlFile() throws Exception {
        List<EbItem> itemList = itemDao.selectItemByIsSelect();

        System.out.println(itemList.size());

        //开始创建solr对象并导入索引库使用solrJ
        SolrServer ss = EcpsUtils.getSolrServer("solr_path");
        for(EbItem item:itemList) {
            //创建文档对象
            SolrInputDocument sd = new SolrInputDocument();
            sd.addField("id", item.getItemId());
            sd.addField("item_name", item.getItemName());
            sd.addField("brand_id", item.getBrandId());
            sd.addField("sku_price", item.getSkuprice());
            sd.addField("promotion", item.getPromotion());
            sd.addField("item_keywords", item.getKeywords());
            sd.addField("imgs", item.getImgs());

            String paraVals = "";
            for(EbParaValue paraVal : item.getParaList()) {
                paraVals = paraVals +paraVal.getParaValue() + " ";
            }

            sd.addField("para_vals", paraVals);

            ss.add(sd);
            ss.commit();
        }
    }

}
