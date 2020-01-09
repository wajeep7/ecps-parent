package com.rl.ecps.service;

import com.rl.ecps.model.EbCart;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface EbCartService {
    public void addCart(HttpServletRequest request,HttpServletResponse response, Long skuId, Integer quantity);

    public List<EbCart> selectCart(HttpServletRequest request, HttpServletResponse response);

    public void delectCart(HttpServletRequest request,HttpServletResponse response,Long skuId);

    public void ModifyCart(HttpServletRequest request,HttpServletResponse response,Long skuId,Integer mdQuantity);

    public void cleatCart(HttpServletRequest request,HttpServletResponse response);

    public String validCartStock(HttpServletRequest request,HttpServletResponse response);
}
