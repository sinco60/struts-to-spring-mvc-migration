package io.levvel.example.spring.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;


@Configuration
@Import(value= {WebMvcConfig.class})
public class MainConfig {
	private static final Logger logger = LoggerFactory.getLogger(MainConfig.class);

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Autowired
	private Environment environment;

	@PostConstruct
	public void initApp() {
		if (environment.getActiveProfiles().length == 0) {
			logger.info("No Spring profile configured, using default configuration.");
		} else {
			for (String springProfile : environment.getActiveProfiles()) {
				logger.info("Detected Spring profile:" + springProfile);
			}
		}
	}
}
