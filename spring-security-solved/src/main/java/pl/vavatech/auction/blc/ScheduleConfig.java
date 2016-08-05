package pl.vavatech.auction.blc;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.util.ErrorHandler;

@Configuration
// @EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {

	@Inject
	@Qualifier("schedulingExecutor")
	ThreadPoolTaskScheduler schedulingExecutor;

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(schedulingExecutor);
	}

	@Bean(name = "schedulingExecutor", destroyMethod = "destroy")
	public ThreadPoolTaskScheduler executor() {
		ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
		taskScheduler.setErrorHandler(new ErrorHandler() {

			@Override
			public void handleError(Throwable arg0) {
				System.out.println("Jest zle " + arg0);

			}
		});
		taskScheduler.setPoolSize(2);
		return taskScheduler;
	}
}
