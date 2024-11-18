package com.genesis.brewery.services;

import com.genesis.brewery.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerById(UUID beerId);

    BeerDTO createBeer(BeerDTO beerDTO);

    void updateBeer(UUID uuid, BeerDTO beerDTO);

    void deleteById(UUID uuid);
}
