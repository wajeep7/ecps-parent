package com.rl.ecps.controller;

import com.rl.ecps.model.EbOrder;
import com.rl.ecps.model.TaskBean;
import com.rl.ecps.service.EbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private EbOrderService orderService;


    @RequestMapping("/toOrder.do")
    public String toOrder(){
        return "/order/index";
    }


    @RequestMapping("/listOrderDetail.do")
    public String listOrderDetail(String assignee, Short isCall, Model model){
        List<TaskBean> tList = orderService.selectTaskBeanBybusinessKey(assignee, isCall);
        model.addAttribute("tList",tList);
        model.addAttribute("isCall",isCall);
        return "/order/orderPay/orderPay";
    }


    @RequestMapping("/viewDetail.do")
    public String viewDetail(Long orderId,String taskId,Model model,String fileName){
        TaskBean tb = orderService.selectOrderById(orderId, taskId);

        model.addAttribute("tb",tb);
        return "/order/"+fileName+"/detail";

        /*return "/order/orderPay/detail";*/
    }


}
