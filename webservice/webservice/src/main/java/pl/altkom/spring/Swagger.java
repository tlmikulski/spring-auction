package pl.altkom.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mangofactory.swagger.plugin.EnableSwagger;

@Profile("prod")
@Configuration
@EnableSwagger
public class Swagger {

}
