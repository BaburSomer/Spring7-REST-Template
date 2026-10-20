package com.babsom.spring7resttemplate.client.impl;

import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.babsom.spring7resttemplate.client.BeerClient;
import com.babsom.spring7resttemplate.model.BeerDTO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

	private final RestTemplateBuilder builder;
    
	@Override
	public Page<BeerDTO> listBeers() {
		RestTemplate restTemplate = builder.build();

		ResponseEntity<PageImpl<BeerDTO>> response = restTemplate.exchange(
				"http://localhost:8080/api/v1/beer",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<PageImpl<BeerDTO>>() {}
		);

		return response.getBody();
	}
}
