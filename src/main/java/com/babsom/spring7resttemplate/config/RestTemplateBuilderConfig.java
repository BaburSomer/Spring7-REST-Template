package com.babsom.spring7resttemplate.config;

import java.time.Duration;

import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.boot.restclient.autoconfigure.RestTemplateBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateBuilderConfig {

	public static final String BASE_URL = "http://localhost:8080";
	
	@Bean
	RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {
		RestTemplateBuilder configuration = configurer.configure(new RestTemplateBuilder());
		
		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(BASE_URL);
		
		return configuration.connectTimeout(Duration.ofSeconds(5))  // bu şekilde olmak zorunda. RestTemplateBuilder is immutable çünkü.
				 					.readTimeout(Duration.ofSeconds(2))
				 					.uriTemplateHandler(uriBuilderFactory);
	}

}
