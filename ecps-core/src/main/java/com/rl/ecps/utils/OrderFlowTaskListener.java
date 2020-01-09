package com.rl.ecps.utils;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class OrderFlowTaskListener implements TaskListener {

	/**
	 * 是你在服务器中唯一id如果不给下次再起服务可能就会报错
	 */
	private static final long serialVersionUID = -8345398692656686728L;

	/**
	 * 这个方法其实就是在执行这些任务
	 * 走到某个一个任务上时我才去给这个任务分配一个角色
	 */
	public void notify(DelegateTask delegateTask) {
		String taskKey = delegateTask.getTaskDefinitionKey();
		
		delegateTask.setAssignee(taskKey + "er");   //给每个任务分配了一个角色
		
	}

}
