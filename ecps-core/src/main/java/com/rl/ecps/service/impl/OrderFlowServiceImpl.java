package com.rl.ecps.service.impl;

import com.rl.ecps.model.EbOrder;
import com.rl.ecps.model.TaskBean;
import com.rl.ecps.service.OrderFlowService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.activiti.engine.impl.pvm.PvmTransition;
import org.activiti.engine.impl.pvm.process.ActivityImpl;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderFlowServiceImpl implements OrderFlowService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    @Override
    public void deployInstance() {
        DeploymentBuilder db = repositoryService.createDeployment();
        db.addClasspathResource("com/rl/ecps/activiti/OrderFlow.xml").addClasspathResource("com/rl/ecps/activiti/OrderFlow.png");
        db.deploy();
    }

    @Override
    public String startInstance(Long orderId) {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("OrderFlow", orderId + "");

        return processInstance.getId();
    }

    @Override
    public void complateInstance(String processInstanceId, String outCome) {
        Task task = taskService.createTaskQuery().processDefinitionKey("OrderFlow").processInstanceId(processInstanceId).singleResult();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("outcome", outCome);
        taskService.complete(task.getId(), map);

    }

    @Override
    public List<TaskBean> selectTaskBeanBybusinessKey(String assignee) {
        List<TaskBean> taskBeanList = new ArrayList<TaskBean>();

        //工作流的查询对象
        List<Task> tasklist = taskService.createTaskQuery().processDefinitionKey("OrderFlow")
                .taskAssignee(assignee).orderByTaskCreateTime().desc().list();

        //实列查询对象
        ProcessInstanceQuery pq = runtimeService.createProcessInstanceQuery();
        for (Task tasks : tasklist) {
            TaskBean tb = new TaskBean();
            ProcessInstance pi = pq.processInstanceId(tasks.getProcessInstanceId()).singleResult();
            String businessKey = pi.getBusinessKey();

            tb.setTask(tasks);
            tb.setBusinessKey(businessKey);
            //返回是咧对象

            taskBeanList.add(tb);

        }


        return taskBeanList;
    }

    @Override
    public TaskBean selectTaskByTaskId(String taskId) {
        //穿件任务ID
        TaskBean taskBean = new TaskBean();
        //根据 主键ORDERFLW 这个KEy 对应xml 文件的ID
        Task task = taskService.createTaskQuery().processDefinitionKey("OrderFlow").taskId(taskId).singleResult();
        System.out.println("我是taskID我有没有er????????????????????????????????????????????????????????????" + taskId);
        List<String> outcomes = this.getOutcomes(task);
        taskBean.setTask(task);
        taskBean.setOutcome(outcomes);
        return taskBean;
    }

    //返回comes 集合
    private List<String> getOutcomes(Task task) {
        List<String> outcomes = new ArrayList<String>();
        //定义流程图的定义对象
        ProcessDefinitionEntity pe = (ProcessDefinitionEntity) repositoryService.getProcessDefinition(task.getProcessDefinitionId());

        //定义流程图实列对象
        ProcessInstance pi = runtimeService.createProcessInstanceQuery().processDefinitionKey("OrderFlow").processInstanceId(task.getProcessInstanceId()).singleResult();

        //通过是咧对象 ActivityId 拿到  一个实现类 activityIMPL
        ActivityImpl activity = pe.findActivity(pi.getActivityId());
        List<PvmTransition> pvList = activity.getOutgoingTransitions();

        for (PvmTransition pt : pvList) {
            String outcome = (String) pt.getProperty("name");
            outcomes.add(outcome);

        }


        return outcomes;


    }
}
