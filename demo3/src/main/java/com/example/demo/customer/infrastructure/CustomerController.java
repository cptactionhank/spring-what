package com.example.demo.customer.infrastructure;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.demo.customer.CustomerNotFoundException;
import com.example.demo.customer.DocTypeNotFoundException;
import com.example.demo.customer.application.AddFileUseCase;
import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.domain.CustomerFile;
import com.example.demo.customer.domain.CustomerId;
import com.example.demo.customer.domain.CustomerRepository;

import jakarta.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private CustomerRepository customerRepository;
    private AddFileUseCase addFileUseCase;

    public CustomerController(CustomerRepository customerRepository, AddFileUseCase addFileUseCase) {
        this.customerRepository = customerRepository;
        this.addFileUseCase = addFileUseCase;
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
        return customerRepository.findById(id).orElseThrow();
    }

    @PostMapping("/customers/{id}/files")
    public CustomerFile postMethodName(@PathParam("id") CustomerId customerId, @RequestBody CreateFileRequest entity)
            throws DocTypeNotFoundException, CustomerNotFoundException {
        return addFileUseCase.execute(customerId, entity.name(), entity.docTypeId());
    }

}
