package com.example.demo2;

import org.springframework.data.annotation.Id;

public record Greeting(@Id Long id, String name) { }