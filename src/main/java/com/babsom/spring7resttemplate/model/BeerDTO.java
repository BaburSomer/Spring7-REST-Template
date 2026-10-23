package com.babsom.spring7resttemplate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by bas, Babür Somer.
 */
@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BeerDTO {

	private UUID          oid;
	private Integer       version;
	private String        name;
	private BeerStyle     style;
	private String        upc;
	private Integer       quantity;
	private BigDecimal    price;
	private LocalDateTime created;
	private LocalDateTime updated;
}