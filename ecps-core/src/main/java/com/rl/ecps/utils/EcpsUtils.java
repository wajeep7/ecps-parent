package com.rl.ecps.utils;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

public class EcpsUtils {
    private static SolrServer server;

    public static String getPropByKey(String key) {
        // 类加载器 读取流文件
        InputStream is = EcpsUtils.class.getClassLoader().getResourceAsStream("ecps_path.properties");
        Properties ps = new Properties();
        String value = "";
        try {
            // 加载流
            ps.load(is);
            // 通过properties 的键返回值
            value = ps.getProperty(key);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;

    }

    public static SolrServer getSolrServer(String key) {
        if (server != null) {
            return server;
        } else {
            server = new HttpSolrServer(EcpsUtils.getPropByKey(key));
            return server;
        }
    }

    public static void ajaxCommon(String result, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
