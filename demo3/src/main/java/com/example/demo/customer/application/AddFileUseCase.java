package com.example.demo.customer.application;

import com.example.demo.UseCase;
import com.example.demo.customer.CustomerNotFoundException;
import com.example.demo.customer.DocTypeNotFoundException;
import com.example.demo.customer.domain.CustomerFile;
import com.example.demo.customer.domain.CustomerId;
import com.example.demo.customer.domain.CustomerRepository;
import com.example.demo.doctype.DocTypeService;
import com.example.demo.doctype.DocTypeId;

@UseCase
public class AddFileUseCase {
    private final CustomerRepository customerRepository;
    private final DocTypeService docTypeService;

    public AddFileUseCase(CustomerRepository customerRepository, DocTypeService docTypeService) {
        this.customerRepository = customerRepository;
        this.docTypeService = docTypeService;
    }

    public CustomerFile apply(CustomerId customerId, String name, DocTypeId docTypeId)
            throws DocTypeNotFoundException, CustomerNotFoundException {
        var docType = docTypeService.findById(docTypeId).orElseThrow(
                () -> new DocTypeNotFoundException());
        var customer = customerRepository.findById(customerId).orElseThrow(
                () -> new CustomerNotFoundException());

        customer.addFile(name, docType.id());
        customerRepository.save(customer);

        return customer.files().stream()
                .filter(f -> f.name().equals(name))
                .findFirst()
                .orElseThrow();
    }
}
