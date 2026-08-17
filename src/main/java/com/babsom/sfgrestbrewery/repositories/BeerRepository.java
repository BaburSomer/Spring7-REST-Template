package com.babsom.sfgrestbrewery.repositories;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.babsom.sfgrestbrewery.domain.Beer;
import com.babsom.sfgrestbrewery.domain.BeerStyleEnum;

import java.util.UUID;

@RepositoryRestResource(path="beer", collectionResourceRel = "biralar") /* collectionResourceRel ile response'ta dönen array'in adını belirleyebiliyorsun */
public interface BeerRepository extends JpaRepository<Beer, UUID> {
    Page<Beer> findAllByBeerName(String beerName, Pageable pageable);

    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);

    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageable);

    Beer findByUpc(String upc);
}
