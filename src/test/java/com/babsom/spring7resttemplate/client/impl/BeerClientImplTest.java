package com.babsom.spring7resttemplate.client.impl;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.babsom.spring7resttemplate.model.BeerDTO;
import com.babsom.spring7resttemplate.model.BeerStyle;

@SpringBootTest
class BeerClientImplTest {

	@Autowired
	BeerClientImpl client;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void listBeersWithNoParams() {
		client.listBeers();
	}

	@Test
	void listBeersByName() {
		client.listBeers("ALE", null, null, null, null);
	}

	@Test
	void listBeersByStyle() {
		client.listBeers(null, BeerStyle.PILSNER, null, null, null);
	}

	@Test
	void getBeerByOid() {
		Page<BeerDTO> beers = client.listBeers();
		
		BeerDTO beer = beers.getContent().getFirst();
		
		BeerDTO beerByOid = client.getBeerByOid(beer.getOid());
		
		assertNotNull(beerByOid);
	}
	
	@Test
	void createBeer() {
		BeerDTO newBeer = BeerDTO.builder().name("Efes Glutensiz")
													  .price(new BigDecimal(50.99))
													  .style(BeerStyle.PILSNER)
													  .upc("45948743643786")
													  .quantity(500)
													  .build();
		BeerDTO savedBeer = client.createBeer(newBeer);
		
		assertNotNull(savedBeer);
	}
}
