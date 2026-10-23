package com.babsom.spring7resttemplate.client.impl;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.babsom.spring7resttemplate.client.BeerClient;
import com.babsom.spring7resttemplate.model.BeerDTO;
import com.babsom.spring7resttemplate.model.BeerDTOPageImpl;
import com.babsom.spring7resttemplate.model.BeerStyle;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

	private static final String       LIST_BEERS = "/api/v1/beer";
	private static final String       GET_BEER_BY_OID = "/api/v1/beer/{oid}";
	
	private final RestTemplateBuilder builder;

	@Override
	public Page<BeerDTO> listBeers() {
		return this.listBeers(null, null, null, null, null);

//		RestTemplate restTemplate = builder.build();
//
//		UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromPath(LIST_BEERS);
//		
//		ResponseEntity<String> responseAsString = restTemplate.getForEntity(componentsBuilder.toUriString(), String.class);
//		System.out.println(responseAsString.getBody());
//
//		ResponseEntity<Map> responseAsMap = restTemplate.getForEntity(componentsBuilder.toUriString(), Map.class);
//		responseAsMap.getBody().entrySet().forEach(entry -> System.out.println(entry.toString()));
//		
//		ResponseEntity<JsonNode> responseAsJsonNode = restTemplate.getForEntity(componentsBuilder.toUriString(), JsonNode.class);
//		responseAsJsonNode.getBody().findPath("content").asArray().forEach(node -> System.out.println(node.get("name").asString()));
//		
//		ResponseEntity<BeerDTOPageImpl> responseAsRestPage = restTemplate.getForEntity(componentsBuilder.toUriString(), BeerDTOPageImpl.class);
//		responseAsJsonNode.getBody().findPath("content").asArray().forEach(node -> System.out.println(node.get("name").asString()));
//
//		return responseAsRestPage.getBody();
	}

	@Override
	public Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize) {
		RestTemplate restTemplate = builder.build();

		UriComponentsBuilder componentsBuilder = UriComponentsBuilder.fromPath(LIST_BEERS);
		if (beerName != null) {
			componentsBuilder.queryParam("name", beerName);
		}

		if (beerStyle != null) {
			componentsBuilder.queryParam("style", beerStyle);
		}

		if (showInventory != null) {
			componentsBuilder.queryParam("showInventory", beerStyle);
		}

		if (pageNumber != null) {
			componentsBuilder.queryParam("pageNumber", beerStyle);
		}

		if (pageSize != null) {
			componentsBuilder.queryParam("pageSize", beerStyle);
		}

		ResponseEntity<BeerDTOPageImpl> response = restTemplate.getForEntity(componentsBuilder.toUriString(), BeerDTOPageImpl.class);

		return response.getBody();
	}

	public BeerDTO getBeerByOid(UUID oid) {
		RestTemplate restTemplate = builder.build();
		return restTemplate.getForObject(GET_BEER_BY_OID, BeerDTO.class, oid);
	}

	public BeerDTO createBeer(BeerDTO beer) {
		RestTemplate restTemplate = builder.build();
		
//		ResponseEntity response = restTemplate.postForEntity(LIST_BEERS, newBeer, BeerDTO.class); böyle header'ın içinden oid'yi ayıklaman gerekiyor. Onun yerine postF0rLocation kullan
		
		URI uri = restTemplate.postForLocation(LIST_BEERS, beer);
		
		return restTemplate.getForObject(uri.getPath(), BeerDTO.class);
	}

	public BeerDTO updateBeer(BeerDTO createdBeer) {
		RestTemplate restTemplate = builder.build();
		
		restTemplate.put(GET_BEER_BY_OID, createdBeer, createdBeer.getOid());
		
		return getBeerByOid(createdBeer.getOid());
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
