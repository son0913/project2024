package com.moon.mProject.config;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.moon.mProject.schedule.LostItemFoundJob;

@Configuration
public class QuartzConfig {
	
	//Job 설정
	@Bean
	public JobDetail jobDetail() {
		return JobBuilder.newJob(LostItemFoundJob.class)
						.withIdentity("lostItemFoundJob")//Job 이름설정
						.storeDurably() //JobDetail을 지속적으로 저장
						.build(); //설정 만듬
	}
	
	//Trigger 설정(Cron표현식 사용)
	//Trigger는 Job이 실행되는 조건을 설정.
	@Bean
	public Trigger trigger(JobDetail jobDetail) {
		return TriggerBuilder.newTrigger()
							.forJob(jobDetail)
							.withIdentity("lostItemFoundJobTrigger")
							.withSchedule(CronScheduleBuilder.cronSchedule("0 0 2 * * ?")) //메일 새벽 2시 마다 
							.build();
	}
}
