package com.example.demo.content.infrastructure;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.content.Content;
import com.example.demo.content.ContentId;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/content/{id}")
public class ContentController {

    @GetMapping()
    public Content list(@RequestParam ContentId id) {
        return new Content(id, "Hello, World!");
    }        
}
