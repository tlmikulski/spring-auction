package pl.vavatech.auction.blc;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	@Inject
	InitializationService initializationService;

	@PostConstruct
	public void init() {
		initializationService.init();
	}
}
