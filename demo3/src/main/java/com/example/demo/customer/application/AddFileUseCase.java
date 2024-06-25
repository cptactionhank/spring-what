package com.example.demo.customer.application;

import com.example.demo.UseCase;
import com.example.demo.customer.domain.CustomerFile;
import com.example.demo.customer.domain.CustomerId;
import com.example.demo.customer.domain.CustomerRepository;
import com.example.demo.doctype.DocTypeId;

@UseCase
public class AddFileUseCase {
    private CustomerRepository customerRepository;

    public AddFileUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerFile execute(CustomerId customerId, String name, DocTypeId docTypeId) {
        var customer = customerRepository.findById(customerId).orElseThrow();
        customer.addFile(name, docTypeId);
        customerRepository.save(customer);

        return customer.files().stream()
            .filter(f -> f.name().equals(name))
            .findFirst()
            .orElseThrow();
    }
}
