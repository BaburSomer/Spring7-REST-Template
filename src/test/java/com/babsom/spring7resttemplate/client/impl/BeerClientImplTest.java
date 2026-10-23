package com.babsom.spring7resttemplate.client.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
