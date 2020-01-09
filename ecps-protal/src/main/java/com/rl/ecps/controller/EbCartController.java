package com.rl.ecps.controller;

import com.rl.ecps.model.EbCart;
import com.rl.ecps.service.EbCartService;
import com.rl.ecps.utils.EcpsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/cart")
public class EbCartController {

    @Autowired
    private EbCartService cartService;

    @RequestMapping("/addCart.do")
    public String addCart(HttpServletRequest request, HttpServletResponse response, Long skuId, Integer quantity){
            cartService.addCart(request,response,skuId,quantity);
            return "redirect:selectCart.do";
    }


    @RequestMapping("/selectCart.do")
    public String selectCart(HttpServletRequest request, HttpServletResponse response, Model model){
        Integer totalNum=0;
        BigDecimal totalPrice=new BigDecimal(0);
        List<EbCart> cartList = cartService.selectCart(request, response);
        for (EbCart cart:cartList){
            totalNum=totalNum+cart.getQuantity();
            totalPrice=totalPrice.add(cart.getSku().getSkuPrice().multiply(new BigDecimal(cart.getQuantity())));

        }
        model.addAttribute("totalNum",totalNum);
        model.addAttribute("totalPrice",totalPrice);
        model.addAttribute("cartList",cartList);
        return "/shop/car";
    }


    @RequestMapping("/RemoveCart.do")
    public String RemoveCart(HttpServletRequest request, HttpServletResponse response, Long skuId){
        cartService.delectCart(request,response,skuId);
        return "redirect:selectCart.do";
    }


    @RequestMapping("/cleanCart.do")
    public String cleanCart(HttpServletRequest request, HttpServletResponse response){
        cartService.cleatCart(request,response);
        return "redirect:selectCart.do";

    }

    @RequestMapping("/modifCart.do")
    public String modifCart(HttpServletRequest request,HttpServletResponse response,Long skuId,Integer  mdQuantity ){
        cartService.ModifyCart(request,response,skuId,mdQuantity);
        return "redirect:selectCart.do";
    }

    @RequestMapping("/validCartStock.do")
    public void validCartStock(HttpServletResponse response,HttpServletRequest request){
        String result = cartService.validCartStock(request, response);
        EcpsUtils.ajaxCommon(result,response);
    }




}
