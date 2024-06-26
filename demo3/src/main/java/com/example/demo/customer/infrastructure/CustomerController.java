package com.example.demo.customer.infrastructure;

import java.util.List;

import com.example.demo.customer.CustomerNotFoundException;
import com.example.demo.customer.DocTypeNotFoundException;
import com.example.demo.customer.application.AddFileUseCase;
import com.example.demo.customer.domain.Customer;
import com.example.demo.customer.domain.CustomerFile;
import com.example.demo.customer.domain.CustomerId;
import com.example.demo.customer.domain.CustomerRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public Customer findById(@PathVariable Long id) {
        return customerRepository.findById(new CustomerId(id)).orElseThrow();
    }

    @PostMapping("/customers/{id}/files")
    public CustomerFile postMethodName(@PathVariable Long id, @RequestBody CreateFileRequest entity)
            throws DocTypeNotFoundException, CustomerNotFoundException {
        return addFileUseCase.apply(new CustomerId(id), entity.name(), entity.docTypeId());
    }
}
