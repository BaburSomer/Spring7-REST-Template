package com.babsom.spring7resttemplate.client.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BeerClientImplTest {
	
	@Autowired
	BeerClientImpl client;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void listBeers() {
		client.listBeers();
	}

}
