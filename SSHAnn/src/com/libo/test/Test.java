package com.libo.test;

import java.util.Date;

import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;

public class Test {
	public static void main(String[] args) throws SchedulerException {
		//����һ������
		JobDetail detail=new JobDetail("�ҵ�����", "1��", MyJob.class);
		JobDataMap map=detail.getJobDataMap();
		map.put("username","�û���");
		//����һ��������
		long now=System.currentTimeMillis();
		Date time=new Date(now+1000);
		SimpleTrigger trigger=new SimpleTrigger("�ҵĴ�����",time,new Date(now+9000),-1,3000);
		//trigger.setStartTime(new Date(System.currentTimeMillis()+1000));
		//����һ��������
		SchedulerFactory sf=new StdSchedulerFactory();
		Scheduler sch=sf.getScheduler();
		sch.scheduleJob(detail, trigger);
		sch.start();
	}
}
