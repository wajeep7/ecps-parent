package com.rl.ecps.dao;

import com.rl.ecps.model.EbOrder;

import java.util.List;

public interface EbOrderDao {

    public void saveOrder(EbOrder order);

    public void updateOrder(EbOrder order);

    public EbOrder selectByOrderId(Long orderId);

    public EbOrder selectOrderDetialById(Long orderId);

}
