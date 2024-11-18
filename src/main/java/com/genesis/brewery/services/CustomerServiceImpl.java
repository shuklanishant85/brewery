package com.genesis.brewery.services;

import com.genesis.brewery.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getById(UUID id) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name("Nishant")
                .build();
    }

    @Override
    public void deleteById(UUID id) {
        //todo: implement delete customer
    }

    @Override
    public void updateCustomer(UUID id, CustomerDTO customerDTO) {
        //todo: implement update customer
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder()
                .id(UUID.randomUUID())
                .name(customerDTO.getName())
                .build();
    }
}
