package pl.vavatech.auction.blc;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ComponentScan("pl.vavatech.auction.blc")
@ImportResource("spring/blc-context.xml")
public class SpringConfig {
	@Inject
	InitializationService initializationService;

	@PostConstruct
	public void init() {
		initializationService.init();
	}
}
