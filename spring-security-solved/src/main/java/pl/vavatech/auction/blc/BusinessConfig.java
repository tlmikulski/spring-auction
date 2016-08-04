package pl.vavatech.auction.blc;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import pl.vavatech.auction.blc.service.UserService;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement
// tx
@ComponentScan("pl.vavatech.auction.blc")
@PropertySource(value = { "classpath:config.properties" })
public class BusinessConfig {
	@Value("${db.driverClassName}")
	private String driverClassName;
	@Value("${db.url}")
	private String url;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String password;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	UserService userService() {
		return new UserService();
	}

	// jpa
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean emFactory = new LocalContainerEntityManagerFactoryBean();
		emFactory.setPersistenceUnitName("auction");
		emFactory.setDataSource(dataSource());
		emFactory.setPackagesToScan(new String[] { "pl.vavatech.auction.blc.model" });
		emFactory.setJpaVendorAdapter(createHibernateAdapter());
		emFactory.getJpaPropertyMap().putAll(getHibernateProperties());
		return emFactory;
	}

	// jpa
	public Map<String, Object> getHibernateProperties() {
		Map<String, Object> properties = new HashMap();
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);

		return properties;
	}

	// jpa
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		return dataSource;

	}

	// jpa
	private HibernateJpaVendorAdapter createHibernateAdapter() {
		HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
		hibernateJpaVendorAdapter.setGenerateDdl(true);
		hibernateJpaVendorAdapter.setDatabase(Database.HSQL);
		return hibernateJpaVendorAdapter;
	}

	// tx
	@Bean
	@Autowired
	public JpaTransactionManager transactionManager(EntityManagerFactory em) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(em);
		return txManager;
	}
}
