package com.rl.ecps.controller;

import com.rl.ecps.MyException.SkuStockExecption;
import com.rl.ecps.model.*;
import com.rl.ecps.service.EbCartService;
import com.rl.ecps.service.EbOrderService;
import com.rl.ecps.service.EbShipAddrService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.omg.CORBA.LongHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private EbShipAddrService shipAddrService;
    @Autowired
    private EbCartService cartService;

    @Autowired
    private EbOrderService orderService;


    @RequestMapping("/toSubmitOrder.do")
    public String toSubmitOrder(HttpServletRequest request, HttpServletResponse response, Model model, HttpSession session) {
        TsPtlUser user = (TsPtlUser) session.getAttribute("user");
        List<EbShipAddr> addrList = shipAddrService.selectShipAddrByUserIdWithRedis(user.getPtlUserId());
        model.addAttribute("addrList", addrList);


        List<EbCart> cartList = cartService.selectCart(request, response);
        Integer totalNum = 0;
        BigDecimal totalPrice = new BigDecimal(0);
        for (EbCart cart : cartList) {
            totalNum = totalNum + cart.getQuantity();
            totalPrice = totalPrice.add(cart.getSku().getSkuPrice().multiply(new BigDecimal(cart.getQuantity())));

        }
        model.addAttribute("totalNum", totalNum);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("cartList", cartList);
        return "/shop/confirmProductCase";
    }


    @RequestMapping("/SubmitOrder.do")
    public String SubmitOrder(EbOrder order, String address, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model) throws InvocationTargetException, IllegalAccessException {
        //address为 shiaddrid
        TsPtlUser user = (TsPtlUser) session.getAttribute("user");
        order.setPtlUserId(user.getPtlUserId());
        order.setUsername(user.getUsername());
        order.setOrderNum(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));

        //判断是否是新增地址
        if (!StringUtils.equals("address", "add")) {
            //根据用户和 地址ID 拿到对应用户 所有的地执行系。 添加到订单里
            EbShipAddr shipAddr = shipAddrService.selectShipAddrByUserIdandByShiAddrId(user.getPtlUserId(), new Long(address));
            //赋值 把目标 ship 赋值到order 完成地址信息 赋值到订单 操作
            BeanUtils.copyProperties(order, shipAddr);


        } else {
            //新增操作 根据前台 js 判断

        }

        //订单详细信息 页面最后部分 根据 cookie 购物车信息 添加。到集合
        List<EbCart> cartList = cartService.selectCart(request, response);
        List<EbOrderDetail> orderDetailList = new ArrayList<EbOrderDetail>();
        for (EbCart cart : cartList) {
            EbOrderDetail orderDetail = new EbOrderDetail();
            orderDetail.setItemId(cart.getSku().getItem().getItemId());
            orderDetail.setItemName(cart.getSku().getItem().getItemName());
            orderDetail.setItemNo(cart.getSku().getItem().getItemNo());
            orderDetail.setSkuId(cart.getSkuId());
            List<EbSpecValue> specList = cart.getSku().getSpecList();
            String val = "";
            for (EbSpecValue specValue : specList) {
                val = val + specValue.getSpecValue() + ",";
            }

            /*val=val.substring(0,val.lastIndexOf(","));*/
            val = val.substring(0, val.length() - 1);
            orderDetail.setSkuSpec(val);
            orderDetail.setMarketPrice(cart.getSku().getMarketPrice());
            orderDetail.setSkuPrice(cart.getSku().getSkuPrice());
            orderDetail.setQuantity(cart.getQuantity());
            orderDetailList.add(orderDetail);
        }
        //写入页面 订单
        model.addAttribute("order", order);

        try {

            String processInstanceId = orderService.saveOrder(request, response, order, orderDetailList);

            session.setAttribute("processInstanceId", processInstanceId);
            session.setAttribute("orderId", order.getOrderId());


        } catch (Exception e) {
            if (e instanceof SkuStockExecption) {
                model.addAttribute("tip", "stockError");

            }
        }


        return "/shop/confirmProductCase2";
    }


    @RequestMapping("/orderPlay.do")
    public void orderPlay(HttpSession session, PrintWriter out) {
        String processInstanceId = (String) session.getAttribute("processInstanceId");
        Long orderId = (Long) session.getAttribute("orderId");
        orderService.updateOrder(orderId,processInstanceId);
        out.write("success");

    }


}
