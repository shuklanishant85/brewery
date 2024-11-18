package com.genesis.brewery.services;

import com.genesis.brewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getById(UUID id);

    void deleteById(UUID id);

    void updateCustomer(UUID id, CustomerDTO customerDTO);

    CustomerDTO createCustomer(CustomerDTO customerDTO);
}
