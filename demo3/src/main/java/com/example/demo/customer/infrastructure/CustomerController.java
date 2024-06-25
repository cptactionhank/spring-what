package com.example.demo.customer.infrastructure;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.domain.CustomerId;
import com.example.demo.customer.domain.CustomerRepository;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CustomerController {
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/customers")
    public Customer create(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }    

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer findById(@PathParam("id") CustomerId id) {
        return null;
        // return customerRepository.findById(id).orElseThrow();
    }
}
