package com.example.demo2;

import java.util.List;
import java.util.Objects;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/greetings")
@Transactional
public class GreetingController {

    private final GreetingRepository repository;

    GreetingController(GreetingRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
	public List<Greeting> all() {
		return this.repository.findAll();
	}

    @SuppressWarnings("unused")
    @PostMapping()
    public Greeting create(@RequestBody Greeting greeting) {        
        this.repository.save(greeting);
        this.repository.save(greeting);
        this.repository.save(greeting);

        Objects.requireNonNull(null, "This is a test");

        return this.repository.save(greeting);
    }
}