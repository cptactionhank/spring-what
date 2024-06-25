package com.example.demo.customer.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import com.example.demo.doctype.DocTypeId;

public class Customer {
    @Id 
    final CustomerId id;
    final String name;
    final Set<CustomerFile> files;

    public Customer(CustomerId id, String name, Set<CustomerFile> files) {
        this.id = id;
        this.name = name;
        this.files = new HashSet(files);
    }

    public CustomerId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Set<CustomerFile> files() {
        return Collections.unmodifiableSet(files);
    }

    public void addFile(String name, DocTypeId docTypeId) {
        files.add(new CustomerFile(null, name, AggregateReference.to(docTypeId)));
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", files=" + files +
                '}';
    }
}
