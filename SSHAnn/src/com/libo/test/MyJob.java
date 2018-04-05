package com.libo.test;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job {
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("执行了这个");
		JobDataMap map=arg0.getJobDetail().getJobDataMap();
		System.out.println(map.get("username"));
	}

}
