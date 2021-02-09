package com.rakuten.training;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rakuten.training.dal.ProductDAO;
import com.rakuten.training.dal.ProductDAOInMemImpl;
import com.rakuten.training.service.ProductService;
import com.rakuten.training.service.ProductServiceImpl;
import com.rakuten.training.ui.ProductConsoleUI;







//@Configuration
public class ProductsAppConfiguration {

//	<bean id="daoObj" class="com.rakuten.training.dal.ProductDAOInMemImpl">
//	</bean>
	@Bean
	public ProductDAO daoObj() {
		ProductDAOInMemImpl dao = new ProductDAOInMemImpl();
		return dao;
	}
	
//	<bean id="serviceObj" class="com.rakuten.training.service.ProductServiceImpl">
//	<property name="dao" ref="daoObj"></property>
//  </bean>
	@Bean
	public ProductService serviceObj() {
		ProductServiceImpl service = new ProductServiceImpl();
		service.setDao(daoObj());
		return service;
	}
	
//	<bean id="uiObj" class="com.rakuten.training.ui.ProductConsoleUI">
//	<property name="service" ref="serviceObj"></property>
//	</bean>
	
	@Bean
	public ProductConsoleUI uiObj() {
		ProductConsoleUI ui = new ProductConsoleUI();
		ui.setService(serviceObj());
		return ui;
	}
}
