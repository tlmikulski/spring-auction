package pl.vavatech.auction.www;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import pl.vavatech.auction.blc.BusinessConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Configuration
@ComponentScan(basePackages = "pl.vavatech.auction.www")
@EnableWebMvc
@Import(BusinessConfig.class)
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureMessageConverters(
			List<HttpMessageConverter<?>> converters) {

		converters.add(createJSON());
	}

	@Bean
	public MappingJackson2HttpMessageConverter createJSON() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter(
				builder.build());
		jsonConverter.setPrettyPrint(true);
		jsonConverter.getObjectMapper().disable(
				SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		return jsonConverter;
	}

	@Bean
	public ObjectMapper createOB() {
		return createJSON().getObjectMapper();
	}

}
