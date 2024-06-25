package com.example.demo.customer.infrastructure.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import com.example.demo.customer.domain.CustomerId;

@Component
@WritingConverter
public class WriterCustomerId implements Converter<CustomerId, Long> {

    @Override
    public Long convert(CustomerId source) {
        return source.id();
    }
    
}
