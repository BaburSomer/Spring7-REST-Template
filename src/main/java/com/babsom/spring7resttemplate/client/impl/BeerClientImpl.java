package com.babsom.spring7resttemplate.client.impl;

import java.util.Map;

import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.babsom.spring7resttemplate.client.BeerClient;
import com.babsom.spring7resttemplate.model.BeerDTO;
import com.babsom.spring7resttemplate.model.BeerDTOPageImpl;

import lombok.RequiredArgsConstructor;
import tools.jackson.databind.JsonNode;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

	private static final String LIST_BEERS = "/api/v1/beer";
	private final RestTemplateBuilder builder;
    
	@Override
	public Page<BeerDTO> listBeers() {	
		RestTemplate restTemplate = builder.build();

		ResponseEntity<String> responseAsString = restTemplate.getForEntity(BeerClientImpl.LIST_BEERS, String.class);
		System.out.println(responseAsString.getBody());

		ResponseEntity<Map> responseAsMap = restTemplate.getForEntity(BeerClientImpl.LIST_BEERS, Map.class);
		responseAsMap.getBody().entrySet().forEach(entry -> System.out.println(entry.toString()));
		
		ResponseEntity<JsonNode> responseAsJsonNode = restTemplate.getForEntity(BeerClientImpl.LIST_BEERS, JsonNode.class);
		responseAsJsonNode.getBody().findPath("content").asArray().forEach(node -> System.out.println(node.get("name").asString()));
		
		ResponseEntity<BeerDTOPageImpl> responseAsRestPage = restTemplate.getForEntity(BeerClientImpl.LIST_BEERS, BeerDTOPageImpl.class);
//		responseAsJsonNode.getBody().findPath("content").asArray().forEach(node -> System.out.println(node.get("name").asString()));

		return null;
	}
	
//	@Override
//	public Page<BeerDTO> listBeers() {
//		RestTemplate restTemplate = builder.build();
//		
//		ResponseEntity<PageImpl<BeerDTO>> response = restTemplate.exchange(
//				BeerClientImpl.BASE_URL + BeerClientImpl.LIST_BEERS,
//				HttpMethod.GET,
//				null,
//				new ParameterizedTypeReference<PageImpl<BeerDTO>>() {}
//				);
//		
//		return response.getBody();
//	}
}
