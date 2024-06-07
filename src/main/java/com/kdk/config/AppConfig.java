package com.kdk.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * <pre>
 * -----------------------------------
 * 개정이력
 * -----------------------------------
 * 2024. 6. 7. kdk	최초작성
 * </pre>
 *
 *
 * @author kdk
 */
@Configuration
public class AppConfig {

	@Bean
	public PropertiesFactoryBean application() {
		PropertiesFactoryBean properties = new PropertiesFactoryBean();

		ClassPathResource application = new ClassPathResource("application.properties");

		properties.setLocations(application);
		return properties;
	}

}
