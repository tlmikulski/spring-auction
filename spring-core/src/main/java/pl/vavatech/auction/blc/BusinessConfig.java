package pl.vavatech.auction.blc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import pl.vavatech.auction.blc.service.UserService;

@Configuration // informacja dla springa, że to jest klasa konfiguracyjna
@ComponentScan("pl.vavatech.auction.blc")
@PropertySource(value = { "classpath:application.properties" })
public class BusinessConfig {
	@Bean
	UserService userService() {
		return new UserService();
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}