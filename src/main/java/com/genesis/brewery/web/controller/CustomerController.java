package com.genesis.brewery.web.controller;

import com.genesis.brewery.services.CustomerService;
import com.genesis.brewery.web.model.CustomerDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomer(@PathVariable UUID id) {
        return new ResponseEntity<>(customerService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        CustomerDTO customer = customerService.createCustomer(customerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + customer.getId().toString());
        return new ResponseEntity<>(customer, headers, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable UUID id, @RequestBody CustomerDTO customerDTO) {
        customerService.updateCustomer(id, customerDTO);
        return ResponseEntity.accepted().build();
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable UUID id) {
        customerService.deleteById(id);
    }
}
