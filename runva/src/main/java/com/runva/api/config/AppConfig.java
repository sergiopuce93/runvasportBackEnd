package com.runva.api.config;


import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;


public abstract class AppConfig {

	/**
	 * Session factory
	 *
	 * @return factoryBean
	 */
	public abstract LocalSessionFactoryBean getSessionFactory();

	/**
	 * Transaction manager
	 *
	 * @return transactionManager
	 */
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
	}

}
