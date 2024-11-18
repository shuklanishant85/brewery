package com.genesis.brewery.web.controller;

import com.genesis.brewery.web.model.BeerDTO;
import com.genesis.brewery.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<BeerDTO> getBeer(@PathVariable UUID beerId) {
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BeerDTO> createBeer(@RequestBody BeerDTO beerDTO) {
        BeerDTO beer = beerService.createBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer/" + beer.getUuid().toString());
        return new ResponseEntity<>(beer, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<String> updateBeer(@PathVariable UUID uuid, @RequestBody BeerDTO beerDTO) {
        beerService.updateBeer(uuid, beerDTO);
        return ResponseEntity.accepted().build();
    }


    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID uuid) {
        beerService.deleteById(uuid);
    }

}
