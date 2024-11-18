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
}
