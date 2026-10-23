package com.babsom.spring7resttemplate.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.boot.restclient.autoconfigure.RestTemplateBuilderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestTemplateBuilderConfig {

	@Value("${rest.template.rootUrl}")
	private String rootUrl;
	
	@Bean
	RestTemplateBuilder restTemplateBuilder(RestTemplateBuilderConfigurer configurer) {
		
		assert rootUrl != null;
		
		RestTemplateBuilder configuration = configurer.configure(new RestTemplateBuilder());
		
		DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory(rootUrl);
		
		return configuration.connectTimeout(Duration.ofSeconds(5))  // bu şekilde olmak zorunda. RestTemplateBuilder is immutable çünkü.
				 					.readTimeout(Duration.ofSeconds(2))
				 					.uriTemplateHandler(uriBuilderFactory);
	}

}
