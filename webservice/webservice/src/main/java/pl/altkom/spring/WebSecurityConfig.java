package pl.altkom.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;

@Configuration
@EnableWebMvcSecurity
public class WebSecurityConfig extends
		WebSecurityConfigurerAdapter {

	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfig extends
			WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http)
				throws Exception {
			http.csrf().disable();
			http.authorizeRequests().antMatchers("/**/*")
					.permitAll();
			// http.authorizeRequests().antMatchers("/**/*")
			// .authenticated().and().httpBasic();
		}
	}

	// @Configuration
	// @Order(1)
	// public static class ApiWebSecurityConfig extends
	// WebSecurityConfigurerAdapter {
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.antMatcher("/rest/*").authorizeRequests()
	// .antMatchers("/rest/a").permitAll().anyRequest()
	// .authenticated().and().httpBasic().and().logout()
	// .logoutUrl("/logout").permitAll();
	// }
	// }
	//
	// @Configuration
	// @Order(2)
	// public static class FormWebSecurityConfig extends
	// WebSecurityConfigurerAdapter {
	//
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.authorizeRequests().antMatchers("/", "/home").permitAll()
	// .anyRequest().authenticated().and().formLogin()
	// .loginPage("/login").permitAll().and().logout()
	// .logoutUrl("/logout").permitAll();
	// }
	// }
	//
	// @Autowired
	// public void configureGlobal(
	// AuthenticationManagerBuilder auth)
	// throws Exception {
	// auth.inMemoryAuthentication().withUser("user")
	// .password("password").roles("USER");
	// }

}