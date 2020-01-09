package com.rl.ecps.service;

import com.rl.ecps.model.EbOrder;
import com.rl.ecps.model.EbOrderDetail;
import com.rl.ecps.model.TaskBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface EbOrderService {
    public String saveOrder(HttpServletRequest request, HttpServletResponse response, EbOrder order, List<EbOrderDetail>detailList);

    public void updateOrder(Long orderId,String processInstanceId);

    public List<TaskBean>selectTaskBeanBybusinessKey(String assignee, Short isCall);

    public TaskBean selectOrderById(Long orderId,String taskId);



}
