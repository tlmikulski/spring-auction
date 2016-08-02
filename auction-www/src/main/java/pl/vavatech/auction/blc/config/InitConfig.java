package pl.vavatech.auction.blc.config;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import pl.vavatech.auction.blc.InitializationService;

@Configuration
@DependsOn("entityManagerFactory")
public class InitConfig {

	@Inject
	InitializationService initializationService;

	@PostConstruct
	public void init() {
		initializationService.init();
	}
}