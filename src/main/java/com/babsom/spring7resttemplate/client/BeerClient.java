package com.babsom.spring7resttemplate.client;

import org.springframework.data.domain.Page;

import com.babsom.spring7resttemplate.model.BeerDTO;

public interface BeerClient {

	Page<BeerDTO> listBeers();
}
