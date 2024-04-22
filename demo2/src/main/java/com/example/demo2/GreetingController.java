package com.example.demo2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingRepository repository;

    GreetingController(GreetingRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
	public List<Greeting> all() {
		return this.repository.findAll();
	}

    @PostMapping()
    public Greeting create(@RequestBody Greeting greeting) {        
        return this.repository.save(greeting);
    }
}