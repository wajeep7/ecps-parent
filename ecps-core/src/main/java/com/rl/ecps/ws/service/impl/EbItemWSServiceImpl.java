package com.rl.ecps.ws.service.impl;

import com.rl.ecps.model.EbItem;
import com.rl.ecps.service.EbItemService;
import com.rl.ecps.utils.EcpsUtils;
import com.rl.ecps.utils.FMutil;
import com.rl.ecps.utils.MD5;
import com.rl.ecps.ws.service.EbItemWSService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

//为了spring 业务逻辑 假的service
@WebService
@Service
public class EbItemWSServiceImpl implements EbItemWSService {
    @Autowired
    private EbItemService itemService;


    @Override
    public String publiclishService(Long itemId,String password) throws Exception{
        if(StringUtils.equals(password,EcpsUtils.getPropByKey("web_pass"))) {
            EbItem item = itemService.selectItemDetailByItemId(itemId);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("item", item);
            map.put("path", "http://localhost:8020/ecps-protal");
            map.put("upload_file_path", "http://localhost:8011/ecps-file");
            FMutil.ouputFile("productDetail.ftl", item.getItemId() + ".html", map);
            return "success";
        }else{
            return "fail";
        }
    }
}
