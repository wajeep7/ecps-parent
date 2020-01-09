package com.rl.ecps.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rl.ecps.utils.EcpsUtils;
import com.rl.ecps.utils.UploadResponse;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@Controller
@RequestMapping("/upload")
public class UploadPathController {
    @RequestMapping("/uploadFilePath.do")
    public void uploadFilePath(HttpServletRequest request, PrintWriter out,
                               String lastFilePath) throws IOException {
        // 从请求里找到 multipart 请求（上传文件）
        MultipartHttpServletRequest ms = (MultipartHttpServletRequest) request;

        // 返回请求里 file 格式的所有文件名集合
        Iterator<String> itor = ms.getFileNames();

        // 拿到文件名
        String file = itor.next();
        // 通过文件名 返回MU 类型对象
        MultipartFile mf = ms.getFile(file);
        // 打成Byte
        byte[] bytes = mf.getBytes();

        // 开始起名
        String fileName = System.currentTimeMillis() + "";
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            fileName = fileName + random.nextInt(9);
        }

        // 拿到原始文件的文件名获得后缀名进行拼接处理
        String oldName = mf.getOriginalFilename();
        // 从.后开始截取
        // 截取的后缀
        String suffix = oldName.substring(oldName.indexOf("."));
        // 工具类得到的绝对路径 和后缀。
        String upload_file_path = EcpsUtils.getPropByKey("upload_file_path")+ "/upload/" + fileName + suffix;
        // 相对路径
        String relative_file_path = "/upload/" + fileName + suffix;

        // import com.sun.jersey.api.client.Client;跨服务器上传使用JERSEY 跨服务器使用put请求
        // 前台后台都能共享到
        Client client = Client.create();

        // import org.apache.commons.lang.StringUtils;
        // 如果这个穿过来的 不是空 是有值的 我就通过创建web 对象 把他删除
        if (StringUtils.isNotBlank(lastFilePath)) {
            // 把路径 的文件放入对象里。删除
            WebResource wr = client.resource(lastFilePath);
            wr.delete();
        }

        // 放入绝对路径 准备写入 服务器 file onload 文件夹
        WebResource wr = client.resource(upload_file_path);
        wr.put(bytes);

        // 回调函数写入 相对路径添加到数据库
        JSONObject jo = new JSONObject();
        // 给jo 赋值 键值对 绝对路径 和相对路径都添加
        jo.accumulate("upload_file_path", upload_file_path);
        jo.accumulate("relative_file_path", relative_file_path);
        String result = jo.toString();
        out.write(result);
        // 写会回调函数 回调函数接 json 请求 $parseJson(回调参数) 返回一个JSON 解析json 即可

    }

    // 大字段文件上传
    @RequestMapping("/uploadForFck.do")
    public void uploadForFck(HttpServletRequest request, PrintWriter out)
            throws IOException {
        // 拿文件部分
        MultipartHttpServletRequest ms = (MultipartHttpServletRequest) request;
        Iterator<String> flist = ms.getFileNames();
        String nextFileName = flist.next();
        // 真正找的的 文件 MF
        MultipartFile mf = ms.getFile(nextFileName);
        byte[] mfBytes = mf.getBytes();

        // 命名部分
        String newName = System.currentTimeMillis() + "";
        Random ro = new Random();
        for (int i = 0; i < 3; i++) {
            newName = newName + ro.nextInt(9);
        }
        String oldName = mf.getOriginalFilename();
            String suffix = oldName.substring(oldName.lastIndexOf("."));

        // 拿路径部分
        String upload_file_path = EcpsUtils.getPropByKey("upload_file_path") +"/upload/" + newName + suffix;
        // 写入部分
        Client client = Client.create();
        WebResource wr = client.resource(upload_file_path);
        // 工具 调用静态数据 转发到 file服务器路径
        UploadResponse res = new UploadResponse(UploadResponse.EN_OK, upload_file_path);
        wr.put(mfBytes);
        out.print(res);


    }

}
