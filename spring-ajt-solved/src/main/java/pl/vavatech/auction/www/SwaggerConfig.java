package pl.vavatech.auction.www;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		Predicate<RequestHandler> handlersToInclude = RequestHandlerSelectors
				.any();
		Predicate<String> pathToInclude = PathSelectors.regex("/rest/.*");

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(handlersToInclude).paths(pathToInclude).build();
	}
}
