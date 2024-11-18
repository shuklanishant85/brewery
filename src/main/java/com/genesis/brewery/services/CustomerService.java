package com.genesis.brewery.services;

import com.genesis.brewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getById(UUID id);
}
