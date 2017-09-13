package com.example.task;


import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 动态修改cron中的参数：
 * 1、实现SchedulingConfigurer。
 * 2、实现SchedulingConfigurer中的方法configureTasks.
 * @author PVer
 *
 */
@Configuration
@EnableScheduling
@RestController
public class TaskTemplete implements SchedulingConfigurer{
	
	//指定：秒，分钟，小时，日期，月份，星期，年(可选)。
	private String expression="0/10 * * * * *";
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		Runnable task = new Runnable() {
			@Override
			public void run() {
				System.out.println("动态修改cron参数为:"+new Date());
			}
		};
		Trigger trigger = new Trigger() {
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				CronTrigger cronTrigger = new CronTrigger(expression);
				return cronTrigger.nextExecutionTime(triggerContext);
			}
		};
		taskRegistrar.addTriggerTask(task, trigger);
	}
	
	@RequestMapping(value="/exPr")
	public String exchangExpression(String exPr){
		return "exchangExpression";
	}
	
	/**
	 * cron:定时任务表达式。
	 * 指定：秒，分钟，小时，日期，月份，星期，年(可选)。
	 * *:任意.
	 * spring task 在计算时间的时候，是根据当前服务器的系统时间进行计算.
	 * 如果是每10秒执行一次的话，那么它是从系统时间的0，10，20秒进行计算的.
	 * 如果每一分钟执行一次的话，那么它是从系统时间的1分钟、2分钟进行计算的.
	 * 
	 * @Scheduled(cron="0/10 * * * * *")每10秒执行一次
	 * @Scheduled(cron="0 0/1 * * * * *")每1分钟执行一次
	 * @Scheduled(cron="0 * 14 * * *")每天下午2点开始到2.59分每分钟执行一次
	 * @Scheduled(cron="0 0/5 14 * * *")每天下午2点开始到2.55分每5分钟执行一次
	 * @Scheduled(cron="0 0/5 14,18 * * *")每天下午2点至2.55分和6点至6.55分两个时间段每5分钟执行一次
	 * @Scheduled(cron="0 0_5 14 * * *")每天下午2点至2.05分每1分钟执行一次
	 * @Scheduled(cron="0 10,44 14 * 3 WED")三月的每周三的14.10和14.44执行
	 * @Scheduled(cron="0 15 10 * * MON_FRI")每周一、二、三、四、五的10.15分执行
	 */
	@Scheduled(cron="0/10 * * * * *")
	public void taskOne(){
		System.out.println("我每10秒打印一次");
	}
	/**
	 * 1分钟打印一次
	 */
	@Scheduled(cron="0 0/1 * * * *")
	public void taskTwo(){
		System.out.println("我每1分钟打印一次");
	}
	
}
