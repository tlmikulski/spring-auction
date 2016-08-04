package pl.vavatech.auction.www;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:spring-security.xml")
public class SecurityConfig {
	//
	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.authorizeRequests().antMatchers("/auctions/**")
	// .access("").antMatchers("")
	// .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')").and().formLogin()
	// .permitAll().and().exceptionHandling().accessDeniedPage("/?status=access-denied")
	// .and().logout().logoutRequestMatcher(new
	// AntPathRequestMatcher("/logout"))
	// .logoutSuccessUrl("/?status=logout");
	//
	// }
	//
	// @Autowired
	// public void configureGlobal(AuthenticationManagerBuilder auth) throws
	// Exception {
	// auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	// auth.inMemoryAuthentication().withUser("admin").password("password").roles("ADMIN");
	// auth.inMemoryAuthentication().withUser("remote").password("password").roles("REMOTE");
	// }
}