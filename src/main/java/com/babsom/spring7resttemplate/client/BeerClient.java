package com.babsom.spring7resttemplate.client;

import org.springframework.data.domain.Page;

import com.babsom.spring7resttemplate.model.BeerDTO;
import com.babsom.spring7resttemplate.model.BeerStyle;

public interface BeerClient {

	Page<BeerDTO> listBeers();

	Page<BeerDTO> listBeers(String beerName, BeerStyle beerStyle, Boolean showInventory, Integer pageNumber, Integer pageSize);
}
