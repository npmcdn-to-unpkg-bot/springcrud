/**
 * 
 */
package com.demo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author kalaiselvan.a
 *
 */
@EnableTransactionManagement
@EnableJpaRepositories({ "com.demo.repository" })
@PropertySource({ "classpath:dev/db.properties" })
public class PersistenceJPAConfig {
	
	@Value("${hibernate.dialect}")
	private String dialect;

	@Value("${hibernate.show_sql}")
	private String show_sql;

	@Value("${hibernate.hbm2ddl.auto}")
	private String hbmddl;

	@Value("${database.driver}")
	private String driver;

	@Value("${database.url}")
	private String url;

	@Value("${database.username}")
	private String username;

	@Value("${database.password}")
	private String password;

	@Value("${entitymanager.packages.to.scan}")
	private String package_to_scan;

	Environment env;

	/**
	 * @return
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer PropertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		try {
			String environment = "";
			environment = System.getProperty("active.profile");
			if ("development".equals(environment)) {
				PropertySourcesPlaceholderConfigurer.setLocations(new ClassPathResource("dev/db.properties"));
			} else if ("test".equals(environment)) {
				PropertySourcesPlaceholderConfigurer.setLocations(new ClassPathResource("dev/db.properties"));
			} else {
				PropertySourcesPlaceholderConfigurer.setLocations(new ClassPathResource("dev/db.properties"));
			}
		} catch (Exception e) {
			return new PropertySourcesPlaceholderConfigurer();
		}
		return PropertySourcesPlaceholderConfigurer;

		// return new PropertySourcesPlaceholderConfigurer();
	}

	/**
	 * @return
	 */
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();

		datasource.setDriverClassName(driver);
		datasource.setUrl(url);
		datasource.setUsername(username);
		datasource.setPassword(password);
		return datasource;
	}

	/**
	 * @return
	 */
	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.dialect", dialect);
				setProperty("hibernate.show_sql", show_sql);
				setProperty("hibernate.hbm2ddl.auto", hbmddl);
			}
		};
	}

	/**
	 * @return
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFacotryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFacotryBean.setDataSource(getDataSource());
		entityManagerFacotryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFacotryBean.setPackagesToScan(new String[] { "com.demo.domain" });
		entityManagerFacotryBean.setJpaProperties(hibernateProperties());
		return entityManagerFacotryBean;
	}

	/**
	 * @return
	 */
	@Bean
	@Autowired
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}
}
