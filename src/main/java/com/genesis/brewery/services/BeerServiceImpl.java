package com.genesis.brewery.services;

import com.genesis.brewery.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder()
                .uuid(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beerStyle("Pale Ale")
                .build();
    }

    @Override
    public BeerDTO createBeer(BeerDTO beerDTO) {
        return BeerDTO.builder()
                .uuid(UUID.randomUUID())
                .beerName(beerDTO.getBeerName())
                .beerStyle(beerDTO.getBeerStyle())
                .build();
    }

    @Override
    public void updateBeer(UUID uuid, BeerDTO beerDTO) {
        //todo: update beer
    }

    @Override
    public void deleteById(UUID uuid) {
        //todo: delete beer
    }
}
