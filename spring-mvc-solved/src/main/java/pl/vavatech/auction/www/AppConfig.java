package pl.vavatech.auction.www;

import java.util.Properties;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import pl.vavatech.auction.blc.BusinessConfig;
import pl.vavatech.auction.www.component.CurrencyFormatter;
import pl.vavatech.auction.www.component.RenderingTimeInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.vavatech.auction.www")
@Import(BusinessConfig.class)
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new RenderingTimeInterceptor());
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	// @Bean
	// public MappingJackson2JsonView createMappingJackson2JsonView() {
	// MappingJackson2JsonView mappingJackson2JsonView = new
	// MappingJackson2JsonView();
	// mappingJackson2JsonView.setPrefixJson(true);
	// return mappingJackson2JsonView;
	// }
	@Bean
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
		SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
		Properties mapping = new Properties();
		mapping.put(Exception.class.getName(), "cmm/error");
		resolver.setExceptionMappings(mapping);

		return resolver;
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatterForFieldAnnotation(new CurrencyFormatter());
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}

	@Bean
	public LocalValidatorFactoryBean createJSR303() {
		return new LocalValidatorFactoryBean();
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
}