package pl.vavatech.auction.blc;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;

@Configuration
public class InitConfig {
	@Inject
	InitializationService initializationService;

	@PostConstruct
	private void init() {
		initializationService.init();
	}
}
