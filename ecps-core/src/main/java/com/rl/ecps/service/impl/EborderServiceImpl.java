package com.rl.ecps.service.impl;

import com.rl.ecps.MyException.SkuStockExecption;
import com.rl.ecps.dao.EbOrderDao;
import com.rl.ecps.dao.EbOrderDetailDao;
import com.rl.ecps.dao.EbSkuDao;
import com.rl.ecps.model.EbOrder;
import com.rl.ecps.model.EbOrderDetail;
import com.rl.ecps.model.EbSku;
import com.rl.ecps.model.TaskBean;
import com.rl.ecps.service.EbCartService;
import com.rl.ecps.service.EbOrderService;
import com.rl.ecps.service.EbSkuService;
import com.rl.ecps.service.OrderFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EborderServiceImpl implements EbOrderService {
    @Autowired
    private EbOrderDao orderDao;
    @Autowired
    private EbCartService cartService;

    @Autowired
    private EbOrderDetailDao detailDao;
    @Autowired
    private EbSkuDao skuDao;

    @Autowired
    private EbSkuService skuService;

    @Autowired
    private OrderFlowService flowService;

    @Override
    public String saveOrder(HttpServletRequest request, HttpServletResponse response, EbOrder order, List<EbOrderDetail> detailList) {
        //添加订单
        orderDao.saveOrder(order);

        //添加订单详细信息
        for (EbOrderDetail detail : detailList) {
            detail.setOrderId(order.getOrderId());
            detailDao.saveDetail(detail);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("skuId", detail.getSkuId());
            map.put("quantity", detail.getQuantity());
            int flag = skuDao.updateSkuStock(map);
            if (flag == 0) {
                throw new SkuStockExecption();
            }

            skuService.updateSkuWithRdisDetail(map);
        }

        //修改redis


        //清空cookie 信息 购物车
        cartService.cleatCart(request, response);
        String processInstanceId = flowService.startInstance(order.getOrderId());
        //返回到controller 返回的是工作流的ID
        return processInstanceId;
    }

    @Override
    public void updateOrder(Long orderId, String processInstanceId) {
        EbOrder order = new EbOrder();
        order.setOrderId(orderId);
        order.setIsPaid((short) 1);
        orderDao.updateOrder(order);
        flowService.complateInstance(processInstanceId, "付款");

    }

    @Override
    public List<TaskBean> selectTaskBeanBybusinessKey(String assignee, Short isCall) {
        List<TaskBean> taskBeanList = flowService.selectTaskBeanBybusinessKey(assignee);

        List<TaskBean> taskBeanList1 = new ArrayList<TaskBean>();
        for (TaskBean tb : taskBeanList) {
            Long orderId = new Long(tb.getBusinessKey());
            EbOrder order = orderDao.selectByOrderId(orderId);
            if (order.getIsCall().shortValue() == isCall.shortValue()) {
                tb.setOrder(order);
                taskBeanList1.add(tb);
            }
        }


        return taskBeanList1;
    }

    @Override
    public TaskBean selectOrderById(Long orderId, String taskId) {
        EbOrder order = orderDao.selectOrderDetialById(orderId);
        //操作工作流 并且拿到 下一个流程 线
        TaskBean taskBean = flowService.selectTaskByTaskId(taskId);
        taskBean.setOrder(order);
        return taskBean;
    }


}
