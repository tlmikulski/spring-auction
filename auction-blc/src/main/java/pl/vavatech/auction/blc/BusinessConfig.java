package pl.vavatech.auction.blc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import pl.vavatech.auction.blc.service.UserService;

@Configuration
@ComponentScan("pl.vavatech.auction.blc")
@PropertySource(value = { "classpath:config.properties" })
public class BusinessConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	UserService userService() {
		return new UserService();
	}
}
