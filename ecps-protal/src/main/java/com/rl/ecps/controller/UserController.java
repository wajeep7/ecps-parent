package com.rl.ecps.controller;

import com.rl.ecps.model.EbArea;
import com.rl.ecps.model.EbShipAddr;
import com.rl.ecps.model.TsPtlUser;
import com.rl.ecps.service.EbAreaService;
import com.rl.ecps.service.EbShipAddrService;
import com.rl.ecps.service.TsPtlUserService;
import com.rl.ecps.utils.EcpsUtils;
import com.rl.ecps.utils.MD5;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TsPtlUserService userService;

    @Autowired
    private EbShipAddrService shipAddrService;

    @Autowired
    private EbAreaService areaService;

    @RequestMapping("/toLogin.do")
    public String toLogin() {
        return "/passport/login";
    }


    /*验证码*/
    @RequestMapping("/getImage.do")
    public void getImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("#######################生成数字和字母的验证码#######################");
        BufferedImage img = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);

        // 得到该图片的绘图对象

        Graphics g = img.getGraphics();

        Random r = new Random();

        Color c = new Color(200, 150, 255);

        g.setColor(c);

        // 填充整个图片的颜色

        g.fillRect(0, 0, 68, 22);

        // 向图片中输出数字和字母

        StringBuffer sb = new StringBuffer();

        char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

        int index, len = ch.length;

        for (int i = 0; i < 4; i++) {

            index = r.nextInt(len);

            g.setColor(new Color(r.nextInt(88), r.nextInt(188), r.nextInt

                    (255)));

            g.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 22));
            // 输出的  字体和大小

            g.drawString("" + ch[index], (i * 15) + 3, 18);
            //写什么数字，在图片 的什么位置画

            sb.append(ch[index]);

        }

        //把验证码的值存储在session中目的是校验
        request.getSession().setAttribute("piccode", sb.toString());

        ImageIO.write(img, "JPG", response.getOutputStream());
    }

    @RequestMapping("/Login.do")
    public String login(String username, String password, String captcha, HttpSession session, Model model) {
        String piccode = (String) session.getAttribute("piccode");
        piccode = piccode.toLowerCase();
        captcha = captcha.toLowerCase();
        if (!StringUtils.equals(piccode, captcha)) {
            String tip = "captcha_error";
            model.addAttribute("tip", tip);
            return "/passport/login";
        }
        //Md5加密
        String pass = MD5.GetMD5Code(password);
        System.out.println(password);
        System.out.println("pass" + pass + "____________________++++++++++++++++__________");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("password", pass);
        TsPtlUser loginUser = userService.selectLogin(map);
        System.out.println(loginUser);
        if (loginUser == null) {
            //没有用户
            String tip = "user_error";
            model.addAttribute("tip", tip);
            return "/passport/login";
        }
        session.setAttribute("user", loginUser);

        return "redirect:/item/toIndex.do";

    }

    /**
     * 登录验证 放回USER ajax 返回
     *
     * @param session
     * @param response
     * @throws IOException
     */
    @RequestMapping("/ajaxCom.do")
    public void ajaxUser(HttpSession session, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        TsPtlUser user = (TsPtlUser) session.getAttribute("user");
        JSONObject jb = new JSONObject();
        jb.accumulate("user", user);
        EcpsUtils.ajaxCommon(jb.toString(), response);

    }


    @RequestMapping("/login/toPersson.do")
    public String toPreson() {
        return "/person/index";
    }


    /**
     * 收货地址
     *
     * @return
     */
    @RequestMapping("login/deliverAddress.do")
    public String toDeliverAddress(Model model, HttpSession session) {
        TsPtlUser user = (TsPtlUser) session.getAttribute("user");
        List<EbShipAddr> addrList = shipAddrService.selectAddressByUserId(user.getPtlUserId());
        model.addAttribute("addrList", addrList);
        List<EbArea> areaList = areaService.selectAreaByParentId(0L);
        model.addAttribute("areaList", areaList);
        return "/person/deliverAddress";
    }


    @RequestMapping("/selectAjaxAddress.do")
    public void selectAjaxAddress(Long parentId, HttpServletResponse response) {
        List<EbArea> areaList = areaService.selectAreaByParentId(parentId);
        JSONObject jb = new JSONObject();
        jb.accumulate("areaList", areaList);
        String result = jb.toString();
        EcpsUtils.ajaxCommon(result, response);

    }


    /**
     * 根据地址 用户ID 查询收货信息
     *
     * @param shipAddrId
     * @param response
     */
    @RequestMapping("/selectAjaxAddrByAddrId.do")
    public void selectAjaxAddrByAddrId(Long shipAddrId, HttpServletResponse response) {
        EbShipAddr addr = shipAddrService.selectAjaxAddrByAddrId(shipAddrId);
        JSONObject jb = new JSONObject();
        jb.accumulate("addr", addr);
        String result = jb.toString();
        EcpsUtils.ajaxCommon(result, response);
    }


    @RequestMapping("/saveOrUpdate.do")
    public String addAddr(EbShipAddr addr, HttpSession session) {
        TsPtlUser user = (TsPtlUser) session.getAttribute("user");

        addr.setPtlUserId(user.getPtlUserId());

        Short defaultAddr = addr.getDefaultAddr();
        if (defaultAddr == null) {
            addr.setDefaultAddr((short) 0);

        }
        shipAddrService.saveOrUpdate(addr);

        return "redirect:/user/login/deliverAddress.do";
    }


    @RequestMapping("/toAjaxLogin.do")
    public void loginAjax(String username, String password, String captcha, PrintWriter out, HttpSession session, HttpServletResponse response) {
        String tip = "success";
        //piccode 验证码生成存入的键
        String piccode = (String) session.getAttribute("piccode");
        piccode = piccode.toLowerCase();
        captcha = captcha.toLowerCase();
        if (!StringUtils.equals(piccode, captcha)) {
            tip = "catcha_error";
        }
        String pass = MD5.GetMD5Code(password);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("password", pass);
        TsPtlUser loginUser = userService.selectLogin(map);
        if (loginUser == null) {
            tip = "user_error";

        }

        session.setAttribute("user", loginUser);
        EcpsUtils.ajaxCommon(tip, response);


    }


}
