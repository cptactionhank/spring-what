package com.example.demo2;

import org.springframework.data.repository.ListCrudRepository;

public interface GreetingRepository extends ListCrudRepository<Greeting, Long> { }
