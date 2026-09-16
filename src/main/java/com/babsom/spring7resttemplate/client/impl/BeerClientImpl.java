package com.babsom.spring7resttemplate.client.impl;

import org.springframework.data.domain.Page;

import com.babsom.spring7resttemplate.client.BeerClient;
import com.babsom.spring7resttemplate.model.BeerDTO;

public class BeerClientImpl implements BeerClient {

	@Override
	public Page<BeerDTO> listBeers() {
		return null;
	}
}
