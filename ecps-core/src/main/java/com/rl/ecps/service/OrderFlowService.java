package com.rl.ecps.service;

import com.rl.ecps.model.EbOrder;
import com.rl.ecps.model.TaskBean;

import java.util.List;

public interface OrderFlowService {

    public void deployInstance();

    public String startInstance(Long orderId);


    public void complateInstance(String processInstanceId,String outCome);

    public List<TaskBean> selectTaskBeanBybusinessKey(String assignee);

    public TaskBean selectTaskByTaskId(String taskId);

}
