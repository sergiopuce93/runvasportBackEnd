package com.runva.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuration for CMI data base
 *
 * Establishes hibernate, Postgresql, C3PO configuration
 *
 * @author carlos.guzman
 *
 */
@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.database_connection.dao"),
		@ComponentScan("com.database_connection.service") })
public class AppConfigRunva extends AppConfig {

	/*
	 * (non-Javadoc)
	 *
	 * @see com.database_connection.config.AppConfig#getSessionFactory()
	 */
	@Primary
	@Bean
	@Override
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		return factoryBean;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.database_connection.config.AppConfig#getTransactionManager()
	 */
	@Primary
	@Bean
	@Override
	public HibernateTransactionManager getTransactionManager() {
		return super.getTransactionManager();
	}

}
